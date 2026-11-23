# Branching

A **branch** is an independent line of work. Commits made on one branch don't affect any other branch until the branches are merged. Branches are cheap to create — Git doesn't copy any files — so creating one per task is normal.

Every repository starts with one branch, **`main`**. On a team, `main` is the shared line of work that should always work.

## Working with Branches

```bash
git branch                          # list branches; * marks the current one
git switch -c feature/contact-page  # create a new branch and switch to it
git switch main                     # switch to an existing branch
```
*Listing, creating, and switching branches. Switching changes the files in the working directory to match that branch.*

Older tutorials use `git checkout -b <name>` to create a branch and `git checkout <name>` to switch; they do the same thing. `git status` always names the current branch on its first line — worth checking before every commit.

**Commit before switching.** Uncommitted changes either travel along to the other branch or, if they'd be overwritten, Git refuses to switch.

## Pushing a New Branch

A new branch exists only locally until it's pushed. The first push sets its **upstream** — the remote branch it pairs with:

```bash
git push -u origin feature/contact-page
```
*Publishing a new branch to GitHub. After this, plain `git push` and `git pull` work on the branch.*

## The Feature-Branch Workflow

Most teams use the same simple pattern:

1. Pull the latest `main`.
2. Create a branch for one task, named for it — e.g. `feature/contact-page` or `bugfix/login-timeout`.
3. Commit work on the branch, and push it.
4. Open a [pull request](../../004%20-%20Pull%20Requests/Notes/001%20-%20Pull%20Requests.md) to merge it into `main`.
5. After it's merged, delete the branch.

The key rule: **nobody commits directly to `main`.** Every change reaches `main` through a reviewed merge, so `main` stays stable and everyone can build on it.

## Deleting a Branch

```bash
git branch -d feature/contact-page
```
*Deleting a branch locally after it's been merged. If the branch has commits that haven't been merged yet, Git refuses with "not fully merged" — a safety check against losing work.*
