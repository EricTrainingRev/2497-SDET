# Repositories — Reading Questions

## Creating a Repository

1. Why does Git need a name and email configured before the first commit, and why use the same email as our GitHub account?

2. Deleting the `.git` folder leaves every project file in place. Why is it still so destructive?

3. Why is `git status` worth running between every step of the add-and-commit loop?

4. Why is `Add support phone number to README` a better commit message than `fixed it`? Who is the message really written for?

5. Why do build output, logs, and passwords belong in `.gitignore` rather than in the repository?

6. Why is `.gitignore` itself committed, and why is it best created before the first commit?

## Cloning

1. What does a clone give us that downloading a project's files wouldn't?

2. What is `origin`, and why do `git push` and `git pull` work in a cloned repository without naming it?

3. Why is a clone never followed by `git init`?

## Pushing and Pulling

1. We've made a commit, but our teammates can't see it. Why not?

2. Git refuses our push because the remote has commits we don't have. Why does Git refuse instead of accepting our commits, and what's the fix?

3. On the first push of a new repository, `-u` links our `main` to the remote's `main`. Why does that make every later push and pull simpler?

4. Why do we pull *before* starting work, rather than only when we're ready to push?
