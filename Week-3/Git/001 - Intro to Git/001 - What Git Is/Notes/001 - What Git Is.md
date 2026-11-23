# What Git Is

**Git** is a **version control system**: it records the history of a project's files — every change, who made it, when, and why. Instead of folders full of copies like `report-final-v2-REAL.docx`, there's one project folder and a complete history behind it that we can inspect, compare, and return to.

## Repositories and Commits

A **repository** (or **repo**) is a project folder that Git is tracking. The history lives in a hidden `.git` folder inside it.

The history is made of **commits**. A commit is a **snapshot** of every tracked file at one moment, saved with:

- a **message** describing the change
- the **author** and **date**
- a unique **ID** (a *hash*, such as `a1b2c3d`) that identifies it

```text
a1b2c3d  Add README with contact details
e4f5a6b  Ignore log files
9c8d7e6  Add support phone number
```
*A short history: three commits, newest at the bottom. Each one is a complete snapshot, not just a list of changes.*

## The Three Areas

A change moves through three places on its way into the history:

1. **Working directory** — the files as we see and edit them.
2. **Staging area** — the changes we've chosen to include in the next commit.
3. **Repository** — the committed history.

```text
working directory  --git add-->  staging area  --git commit-->  repository
```
*How a change becomes part of history. Editing a file changes only the working directory until we stage and commit it.*

The staging area lets us choose exactly what goes into each commit — for example, committing a bug fix while leaving an unfinished experiment out.

## Distributed

Git is **distributed**: every copy of a repository holds the *full* history, not just the latest files. We can commit, browse history, and create branches with no network connection at all. Sharing work with a team is a separate step — sending commits to a shared copy and receiving others' commits from it — which is where [GitHub](../../002%20-%20GitHub/Notes/001%20-%20GitHub.md) comes in.
