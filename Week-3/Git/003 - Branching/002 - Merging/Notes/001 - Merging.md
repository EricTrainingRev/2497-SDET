# Merging

**Merging** brings the commits from one branch into another. `git merge` always merges *into the current branch*, so we switch to the branch that should receive the work first.

```bash
git switch main
git merge feature/contact-page
```
*Merging the `feature/contact-page` branch into `main`.*

On a team, merges into `main` usually happen through a pull request on GitHub rather than on the command line — but it's the same operation either way.

## Fast-Forward Merges

If `main` hasn't changed since the feature branch was created, there's nothing to combine. Git just moves `main` forward to the branch's latest commit. This is a **fast-forward**, and no new commit is created.

```text
before:  main ── A ── B
                       └── C ── D   (feature)

after:   main ── A ── B ── C ── D   (main and feature)
```
*A fast-forward: `main` simply catches up to the feature branch.*

## Merge Commits

If `main` *has* moved on — someone else merged work in the meantime — both branches have new commits. Git combines them by creating a **merge commit**, a commit with two parents that joins the two lines of history.

```text
         ┌── C ── D ──────┐   (feature)
main ── A ── B ── E ───── M   (main)
```
*A merge commit `M` joining the feature branch's commits with `main`'s new commit `E`.*

Git writes the merge commit automatically when the branches changed different lines. When both changed the *same* lines, the merge stops with a [merge conflict](../../003%20-%20Merge%20Conflicts/Notes/001%20-%20Merge%20Conflicts.md).

## Seeing the History

```bash
git log --oneline --graph
```
*The history drawn as a graph, showing where branches split off and where they were merged.*

## Keeping a Branch Up to Date

A long-running feature branch can fall behind `main`. Merging `main` *into* the feature branch brings it up to date and surfaces any conflicts early, on the branch, instead of during the final merge:

```bash
git switch feature/contact-page
git fetch origin
git merge origin/main
```
*Updating a feature branch with the latest `main` from GitHub. `git fetch` downloads the remote's commits without merging; `origin/main` is GitHub's copy of `main`.*
