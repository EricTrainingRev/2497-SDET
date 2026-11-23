# Merge Conflicts

A **merge conflict** happens when two branches changed the *same lines* of the same file, and Git can't know which version is right. Instead of guessing, Git stops the merge and asks us to decide. Conflicts are a normal part of teamwork, not an error.

## Recognizing a Conflict

```text
Auto-merging README.md
CONFLICT (content): Merge conflict in README.md
Automatic merge failed; fix conflicts and then commit the result.
```
*Git's output when a merge hits a conflict.*

`git status` lists the conflicted files as **both modified**. Files without conflicts were merged automatically and are already staged.

## Reading the Markers

Inside a conflicted file, Git marks the disputed lines:

```text
# Team Contacts

<<<<<<< HEAD
Support email: help@example.com
=======
Support email: support@acme.com
>>>>>>> origin/main
Office hours: 9am - 5pm
```
*A conflict in `README.md`. Everything outside the markers merged cleanly.*

- Between **`<<<<<<< HEAD`** and **`=======`** is *our* version — the branch we're on.
- Between **`=======`** and **`>>>>>>>`** is *their* version — the branch being merged in, named after the arrows.

## Resolving a Conflict

1. Edit the file to what it *should* say — keep ours, keep theirs, combine them, or write something new.
2. **Delete all three marker lines.**
3. Stage the resolved file and commit to finish the merge.

```bash
git add README.md
git commit --no-edit
```
*Marking the conflict as resolved and completing the merge. `--no-edit` accepts Git's default merge message.*

VS Code highlights conflicts and offers **Accept Current Change**, **Accept Incoming Change**, and **Accept Both Changes** buttons above each one, which edit the file and remove the markers for us. Either way, the result still needs `git add` and `git commit`.

## Backing Out

If a merge goes wrong partway through, it can be cancelled, returning everything to how it was before the merge started:

```bash
git merge --abort
```
*Cancelling an in-progress merge.*

## Fewer Conflicts

- **Pull often** and keep branches short-lived, so they don't drift far from `main`.
- **Keep changes focused** — a branch that touches only what its task needs overlaps with fewer others.
- **Talk to the team** when two people need to change the same file.
