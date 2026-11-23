# Branching — Reading Questions

## Branching

1. Why is it normal to create a new branch for every task, rather than treating a branch as a big decision?

2. Why should we commit before switching branches?

3. Why doesn't a brand-new branch appear on GitHub until it's pushed, and what does `-u` set up on that first push?

4. In the feature-branch workflow, nobody commits directly to `main`. What does that rule protect?

5. `git branch -d` refuses to delete a branch that's "not fully merged." Why is that refusal useful?

## Merging

1. To merge a feature branch into `main`, why do we switch to `main` first?

2. When does a merge end up as a fast-forward, and why does it create no new commit?

3. Why does a merge commit have two parents?

4. Why merge `main` *into* a long-running feature branch before the feature is finished?

## Merge Conflicts

1. Two branches both edited `README.md`. Why might the merge go through cleanly, or stop with a conflict?

2. In a conflicted file, how do we tell which version is ours and which is theirs?

3. VS Code's **Accept Current Change** button edits the file and removes the markers. Why do we still need `git add` and `git commit` afterward?

4. Why do short-lived, focused branches lead to fewer conflicts?

## Pull Requests

1. A pull request ends in an ordinary merge. Why do teams merge through a pull request instead of running `git merge` themselves?

2. A reviewer requests changes on our open pull request. Why don't we need to open a new pull request after fixing them?

3. GitHub disables merging because the pull request has conflicts. Why do we resolve them on the feature branch rather than on `main`?

4. Our pull request was just merged on GitHub. Why does our local `main` still not have the change?
