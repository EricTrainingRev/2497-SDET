# Cloning

**Cloning** makes a complete local copy of a remote repository — every file and the entire history. It's how we join a project that already exists.

```bash
git clone https://github.com/acme/team-contacts.git
cd team-contacts
```
*Cloning a repository from GitHub. Git creates a `team-contacts` folder named after the repository.*

A different folder name can be given as a second argument:

```bash
git clone https://github.com/acme/team-contacts.git contacts
```
*Cloning into a folder called `contacts` instead.*

The URL comes from the repository's GitHub page, under the green **Code** button.

## What Cloning Sets Up

After a clone, the repository is ready to work in immediately:

- The **full history** is present — `git log` shows every commit ever made.
- The default branch (usually `main`) is **checked out**, so the files are ready to edit.
- A remote named **`origin`** is configured, pointing back at the URL we cloned from.

```bash
git remote -v
```
*Listing the remotes. After a clone, `origin` appears with the repository's URL.*

`origin` is just a conventional name — it's what `git push` and `git pull` use by default.

## Clone vs. Init

| Situation | Command |
|---|---|
| Starting a brand-new project | `git init` |
| Joining a project that already exists | `git clone` |

*Which command starts the repository. A clone is never followed by `git init` — it's already a repository.*
