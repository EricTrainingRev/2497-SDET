# Merge Conflict Lab

We'll create two branches that change the same line of a file, merge the first one cleanly as a **fast-forward**, and then merge the second to force a **merge conflict**. Then we'll resolve the conflict and finish the merge by committing while Git is in the **`MERGING`** state, which creates a **merge commit** with two parents.

Everything happens locally. No GitHub account or remote is needed.

## Prerequisites

| Software | Required Version |
|---|---|
| Git | 2.28 or later (`git init -b` needs 2.28; `git switch` needs 2.23) |
| Git Bash | Included with Git for Windows. Mac and Linux terminals work too. |
| VS Code | Any recent version |

Check the Git version:

```bash
git --version
```
*Any version 2.28 or newer works.*

Git stamps every commit with a name and email. If we've never set them on this machine, we set them once now:

```bash
git config --global user.name "Your Name"
git config --global user.email "you@example.com"
```
*One-time setup. Skip this if `git config user.name` already prints a name.*

> **About the output in this lab:** Commit IDs such as `a1b2c3d` are different on every machine. Ours won't match the ones shown here, and that's expected. On Windows, Git may also print `warning: ... LF will be replaced by CRLF`. That's a harmless note about line endings and can be ignored.

---

## Part 1: Set Up the Repository

We'll build a small repository with one file, then commit it so both branches start from the same point.

**1.** Open Git Bash, go to the home folder, and create a folder for the lab:

```bash
cd ~
mkdir merge-conflict-lab
cd merge-conflict-lab
```
*Creating the lab folder in our home directory.*

> Create this folder **outside** any existing repository, including the curriculum repo. A repository nested inside another one confuses both.

**2.** Turn the folder into a repository:

```bash
git init -b main
```

Expected output:

```text
Initialized empty Git repository in C:/Users/<you>/merge-conflict-lab/.git/
```

**3.** Open the folder in VS Code:

```bash
code .
```

**4.** In VS Code, create a new file named `README.md` in the `merge-conflict-lab` folder with exactly this content, then save it:

```text
# Team Contacts

Support email: help@example.com
Office hours: 9am - 5pm
```
*The file both branches will edit. The conflict will happen on the `Support email` line.*

**5.** Back in Git Bash, stage and commit the file:

```bash
git add README.md
git commit -m "Add team contacts README"
```

Expected output:

```text
[main (root-commit) a1b2c3d] Add team contacts README
 1 file changed, 4 insertions(+)
 create mode 100644 README.md
```

---

## Part 2: Create Two Branches

Two teammates are each asked to update the support email, and each picks a different address. We'll play both of them, with one branch each.

**6.** Create the first branch and switch to it:

```bash
git switch -c feature/support-email
```

Expected output:

```text
Switched to a new branch 'feature/support-email'
```

**7.** In VS Code, change the `Support email` line in `README.md` to this, then save:

```text
Support email: support@example.com
```

The whole file should now read:

```text
# Team Contacts

Support email: support@example.com
Office hours: 9am - 5pm
```

**8.** Commit the change on this branch:

```bash
git add README.md
git commit -m "Change support email to support@example.com"
```

Expected output:

```text
[feature/support-email e4f5a6b] Change support email to support@example.com
 1 file changed, 1 insertion(+), 1 deletion(-)
```

**9.** Go back to `main`:

```bash
git switch main
```

Look at `README.md` in VS Code. It shows `help@example.com` again, because the change lives only on `feature/support-email`.

**10.** Create the second branch from `main` and switch to it:

```bash
git switch -c feature/helpdesk-email
```

Expected output:

```text
Switched to a new branch 'feature/helpdesk-email'
```

**11.** In VS Code, change the **same line** to a different address, then save:

```text
Support email: helpdesk@example.com
```

The whole file should now read:

```text
# Team Contacts

Support email: helpdesk@example.com
Office hours: 9am - 5pm
```

**12.** Commit the change on this branch:

```bash
git add README.md
git commit -m "Change support email to helpdesk@example.com"
```

Expected output:

```text
[feature/helpdesk-email 3c4d5e6] Change support email to helpdesk@example.com
 1 file changed, 1 insertion(+), 1 deletion(-)
```

**13.** Look at the history of all three branches:

```bash
git log --oneline --graph --all
```

Expected output (the order of the two branch lines may differ):

```text
* 3c4d5e6 (HEAD -> feature/helpdesk-email) Change support email to helpdesk@example.com
| * e4f5a6b (feature/support-email) Change support email to support@example.com
|/
* a1b2c3d (main) Add team contacts README
```
*Both branches start from the same commit on `main`, and each changed the same line in a different way.*

---

## Part 3: Merge the First Branch (Fast-Forward)

**14.** Switch to `main`, the branch that will receive the work:

```bash
git switch main
```

**15.** Merge the first branch:

```bash
git merge feature/support-email
```

Expected output:

```text
Updating a1b2c3d..e4f5a6b
Fast-forward
 README.md | 2 +-
 1 file changed, 1 insertion(+), 1 deletion(-)
```

This is a **fast-forward**. `main` hadn't changed since `feature/support-email` branched off, so there was nothing to combine. Git just moved `main` forward to the branch's commit, and no new commit was created.

`README.md` on `main` now says `support@example.com`.

---

## Part 4: Force the Conflict

Now `main` has moved: it contains the `support@example.com` change. `feature/helpdesk-email` still branches from the *old* `main` and changed the same line differently, so Git can't decide which version is right.

**16.** Merge the second branch:

```bash
git merge feature/helpdesk-email
```

Expected output:

```text
Auto-merging README.md
CONFLICT (content): Merge conflict in README.md
Automatic merge failed; fix conflicts and then commit the result.
```

**17.** Look at the Git Bash prompt. It now ends in `(main|MERGING)`:

```text
you@MACHINE MINGW64 ~/merge-conflict-lab (main|MERGING)
$
```

**`MERGING`** means Git is **in the middle of a merge**. It has started combining the branches, stopped at the conflict, and is waiting for us to finish. The merge stays open until we commit. Closing the terminal doesn't end it.

**18.** Check the status:

```bash
git status
```

Expected output:

```text
On branch main
You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
	both modified:   README.md

no changes added to commit (use "git add" and/or "git commit -a")
```

- **You have unmerged paths:** at least one file still has an unresolved conflict.
- **both modified:** both branches changed `README.md` in a way Git couldn't combine.
- The hints already list the way forward: fix the conflict, then `git commit`.

**19.** Open `README.md` in VS Code. It now contains:

```text
# Team Contacts

<<<<<<< HEAD
Support email: support@example.com
=======
Support email: helpdesk@example.com
>>>>>>> feature/helpdesk-email
Office hours: 9am - 5pm
```

- Between `<<<<<<< HEAD` and `=======` is **our** version, from `main`, the branch we're on.
- Between `=======` and `>>>>>>> feature/helpdesk-email` is **their** version, from the branch being merged in.
- Every line outside the markers, such as `Office hours`, merged without trouble.

VS Code also shows **Accept Current Change | Accept Incoming Change | Accept Both Changes** above the conflict. We'll edit the file by hand so we can see exactly what a resolution is.

---

## Part 5: Resolve the Conflict and Commit While MERGING

The team agrees that `helpdesk@example.com` is the right address.

**20.** Edit `README.md` so it contains exactly this, with **all three marker lines deleted**, then save:

```text
# Team Contacts

Support email: helpdesk@example.com
Office hours: 9am - 5pm
```
*The resolved file. No `<<<<<<<`, `=======`, or `>>>>>>>` lines remain.*

> A leftover marker line is the most common mistake. Git would commit it as ordinary text. Check the file once more before moving on.

**21.** Mark the conflict as resolved by staging the file:

```bash
git add README.md
```

**22.** Check the status again:

```bash
git status
```

Expected output:

```text
On branch main
All conflicts fixed but you are still merging.
  (use "git commit" to conclude merge)

Changes to be committed:
	modified:   README.md
```

**This is the key moment of the lab.** The conflict is fixed, but the prompt **still reads `(main|MERGING)`**, and Git says *"you are still merging."* Editing the file and running `git add` did **not** finish the merge. Git is waiting for one more thing: **a commit**.

That commit isn't an ordinary commit. Made while Git is in the `MERGING` state, it becomes the **merge commit** that ties the two branches together, so it records **two parents**: the latest commit on `main` and the latest commit on `feature/helpdesk-email`.

**23.** Commit to conclude the merge:

```bash
git commit --no-edit
```

Expected output:

```text
[main 7d8e9f0] Merge branch 'feature/helpdesk-email'
```

`--no-edit` accepts Git's ready-made message, `Merge branch 'feature/helpdesk-email'`. We didn't need `-m`, because Git prepared the message when the merge started.

> **Without `--no-edit`:** A plain `git commit` opens an editor with that message already filled in. In Git Bash the default editor is usually **Vim**. To save and close it, press `Esc`, type `:wq`, and press `Enter`.

**24.** Look at the prompt again. `MERGING` is gone:

```text
you@MACHINE MINGW64 ~/merge-conflict-lab (main)
$
```

The merge is complete.

**25.** Confirm that the merge commit has two parents:

```bash
git log -1
```

Expected output:

```text
commit 7d8e9f0...
Merge: e4f5a6b 3c4d5e6
Author: Your Name <you@example.com>
Date:   ...

    Merge branch 'feature/helpdesk-email'

    # Conflicts:
    #       README.md
```

The **`Merge:`** line lists the two parents: `e4f5a6b` (the `support@example.com` commit on `main`) and `3c4d5e6` (the `helpdesk@example.com` commit on the feature branch). An ordinary commit has no `Merge:` line, because it has only one parent. Git also added a `# Conflicts:` note to the message, recording which files needed a hand-made resolution.

**26.** See the history as a graph:

```bash
git log --oneline --graph --all
```

Expected output:

```text
*   7d8e9f0 (HEAD -> main) Merge branch 'feature/helpdesk-email'
|\
| * 3c4d5e6 (feature/helpdesk-email) Change support email to helpdesk@example.com
* | e4f5a6b (feature/support-email) Change support email to support@example.com
|/
* a1b2c3d Add team contacts README
```
*The two lines of history split at the first commit and join again at the merge commit.*

---

## Part 6: Clean Up

Both branches are fully merged into `main`, so they can be deleted safely.

**27.** Delete the two feature branches:

```bash
git branch -d feature/support-email
git branch -d feature/helpdesk-email
```

Expected output:

```text
Deleted branch feature/support-email (was e4f5a6b).
Deleted branch feature/helpdesk-email (was 3c4d5e6).
```

**28.** Confirm that only `main` remains:

```bash
git branch
```

Expected output:

```text
* main
```

---

## If Something Goes Wrong

| Problem | Fix |
|---|---|
| Step 16 printed `Fast-forward` or `Already up to date` instead of `CONFLICT` | One of the branches didn't change the `Support email` line, or the change wasn't committed. Check with `git log --oneline --graph --all`, compare against step 13, and redo the missing step. |
| The resolution went badly and we want to start the merge over | Run `git merge --abort`. It cancels the merge, removes `MERGING` from the prompt, and puts `README.md` back the way it was before step 16. Then run step 16 again. |
| `git commit` opened Vim and we're stuck | Press `Esc`, type `:wq`, and press `Enter`. |
| `git commit` says `Committing is not possible because you have unmerged files` | The file wasn't staged after resolving it. Run `git add README.md` (step 21), then commit. |
| The committed file still contains `<<<<<<<` or `>>>>>>>` | The markers weren't deleted before `git add`. Edit `README.md` to remove them, then run `git add README.md` and `git commit -m "Remove leftover conflict markers"`. |
