# Pushing and Pulling

Commits are made locally, on our own machine. Nobody else sees them until we **push** them to the remote, and we don't see anyone else's until we **pull** them down.

## Pushing

`git push` sends our new commits to the remote.

```bash
git push
```
*Sending local commits on the current branch to `origin`. In a cloned repository, this works with no extra arguments.*

A repository created with `git init` has no remote yet. To put it on GitHub, we create an **empty** repository on GitHub (no README or other files), then connect and push once:

```bash
git remote add origin https://github.com/acme/team-contacts.git
git push -u origin main
```
*Connecting a local repository to GitHub and pushing it for the first time. `-u` links our `main` to the remote's `main`, so later a plain `git push` or `git pull` knows where to go.*

## Pulling

`git pull` brings down commits that others have pushed, and merges them into our current branch.

```bash
git pull
```
*Downloading and merging the remote's new commits into the current branch.*

When we haven't made any local commits of our own, the pull simply moves our branch forward to match the remote — Git reports this as a **fast-forward**.

## A Rejected Push

If someone else pushed first, our push is refused:

```text
 ! [rejected]        main -> main (fetch first)
hint: Updates were rejected because the remote contains work that you do not
hint: have locally. This is usually caused by another repository pushing to
hint: the same ref.
```
*Git refusing a push: the remote has commits we don't have yet.*

Git won't let a push overwrite other people's work. The fix is to **pull first** — combining their commits with ours — and then push again.

## The Habit

- **Pull before starting work**, so we build on the latest version.
- **Commit often** — small commits are easier to understand and to undo.
- **Push when a piece of work is done**, so teammates can see it.
