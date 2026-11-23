# Pull Requests

A **pull request** (PR) is a request, made on GitHub, to merge one branch into another — almost always a feature branch into `main`. It turns a merge into a conversation: teammates can see exactly what changed, comment on it, and approve it before it lands. (GitLab calls the same thing a *merge request*.)

## The Flow

1. **Push a branch** with the work on it.
2. **Open a pull request** on GitHub. The **base** is the branch to merge into (`main`); the **compare** branch is ours. Give it a clear title and a short description of what changed and why.
3. **Review.** Teammates read the changes and either approve them or request changes, leaving comments on specific lines.
4. **Update** if needed — pushing more commits to the same branch adds them to the open pull request automatically.
5. **Merge** on GitHub once it's approved.
6. **Clean up:** delete the branch (GitHub offers a button), then everyone pulls the updated `main`.

```bash
git switch main
git pull
git branch -d feature/contact-page
```
*After a pull request is merged: update the local `main` and delete the finished local branch.*

## The Pull Request Page

| Tab | Shows |
|---|---|
| **Conversation** | The description, comments, review status, and the merge button |
| **Commits** | Every commit on the branch |
| **Files changed** | The exact lines added and removed — where reviewers comment |

*The main tabs of a pull request on GitHub.*

## Conflicts in a Pull Request

If `main` changed the same lines while the pull request was open, GitHub reports **"This branch has conflicts that must be resolved"** and disables merging. The usual fix is to merge `main` into the feature branch locally, [resolve the conflict](../../003%20-%20Merge%20Conflicts/Notes/001%20-%20Merge%20Conflicts.md), and push:

```bash
git fetch origin
git merge origin/main
# resolve the conflict, then:
git add README.md
git commit --no-edit
git push
```
*Resolving a pull request's conflict on the feature branch. The pull request updates itself and becomes mergeable.*

## Why Teams Use Pull Requests

- **Review** — a second person reads every change before it reaches `main`.
- **Stability** — `main` only receives work that's been seen and agreed on.
- **History** — the pull request keeps the discussion of *why* a change was made, linked to the change itself.
