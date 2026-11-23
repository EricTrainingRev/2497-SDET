# GitHub

Git and GitHub are often mentioned together, but they're different things.

| | Git | GitHub |
|---|---|---|
| What it is | A version control tool | A website that hosts Git repositories |
| Where it runs | On our own machine | In the cloud |
| Works without the other? | Yes — fully, offline | No — it's built on Git |

*Git is the tool; GitHub is one place to keep a shared copy of a repository. GitLab and Bitbucket offer the same idea.*

## Remotes

A **remote** is a copy of a repository hosted somewhere else — on GitHub, for our purposes. A team doesn't send commits directly to each other's laptops; everyone sends commits to the shared remote and receives other people's commits from it.

```text
Alice's repo  <--push / pull-->  GitHub (remote)  <--push / pull-->  Bob's repo
```
*A team sharing work through one remote. Each person still has a complete repository of their own.*

The remote is just another full copy of the repository. What makes it special is the team's agreement that it's the shared, official one.

## What GitHub Adds

On top of hosting the shared copy, GitHub provides:

- **A web view** of the code, its history, and every change
- **Access control** — who can see the repository, and who can push to it
- **A backup** — the project survives a lost laptop
- **Pull requests** — a way to propose, review, and discuss changes before they're merged into the main line of work

Pull requests are the center of how most teams collaborate, and they're covered in the Branching unit.
