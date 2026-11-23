# Creating a Repository

## One-Time Setup

Every commit records its author, so Git needs a name and email before the first commit. This is set once per machine.

```bash
git config --global user.name "Ada Lovelace"
git config --global user.email "ada@example.com"
```
*Setting the identity that's stamped on every commit. Using the same email as our GitHub account links the commits to it.*

## Starting a Repository

`git init` turns the current folder into a repository by creating the hidden `.git` folder.

```bash
mkdir team-contacts
cd team-contacts
git init -b main
```
*Creating a new repository. `-b main` names the first branch `main`.*

Deleting the `.git` folder deletes the entire history, so it's left alone.

## The Everyday Loop

Almost all day-to-day Git is the same three commands, with `git status` in between to see where things stand.

```bash
git status                    # what's changed, what's staged, which branch we're on
git add README.md             # stage one file
git add .                     # or: stage every change in this folder
git commit -m "Add README with contact details"
```
*Check, stage, commit. `git status` is safe to run at any time and is the best habit to build.*

A new file shows as **untracked** until it's added. After `git add`, changes show as **staged** (ready to commit). After the commit, `git status` reports a clean working tree.

## Commit Messages

A commit message explains the change to the next person who reads the history — often ourselves, months later. A good message is a short summary of *what* changed, written as a command:

| Weak | Better |
|---|---|
| `stuff` | `Add support phone number to README` |
| `fixed it` | `Fix login timeout on slow connections` |
| `changes` | `Move contact details into their own section` |

*Weak and better commit messages. "Add," "Fix," and "Move" read as instructions the commit carries out.*

## Reading the History

```bash
git log              # full details: ID, author, date, message
git log --oneline    # one line per commit: short ID and message
```
*Two views of the history, newest commit first.*

## Ignoring Files

Some files shouldn't be in a repository: build output, logs, editor settings, passwords. A file named **`.gitignore`** in the repository lists patterns for files Git should ignore.

```text
# build output
target/

# logs
*.log

# editor settings
.idea/
.vscode/
```
*A `.gitignore`. Each line is a pattern: a folder name with a trailing slash, or a wildcard like `*.log`.*

Ignored files never appear in `git status` and can't be added by accident. The `.gitignore` itself *is* committed, so the whole team shares it. It only affects files Git isn't already tracking — so it's best created before the first commit.
