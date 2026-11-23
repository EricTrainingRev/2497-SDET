# Lab: Intro to HTML

In this lab we build a small "Team Directory" page from scratch — the **page skeleton**, **headings and paragraphs**, a **list of links**, an **image** with alternative text, a **grouping `<div>`** with `id`, `class`, and `data-testid` attributes, a **disabled button**, and a **table** — and then explore the **DOM** the browser builds from it. We finish by inspecting a deliberately broken page to see how the browser repairs bad HTML, and why the DOM a test sees can differ from the file.

---

## Prerequisites

| Software | Required Version |
|---|---|
| Google Chrome or Microsoft Edge | Any current version |
| A code editor (e.g., VS Code) | Any |

No installs or servers. The lab has three files:

- `src/index.html` — the page we build. It contains `TODO 1`–`TODO 6`.
- `src/broken.html` — a provided page with mistakes in it. Don't fix it; we're studying it.
- `dom-questions.md` — questions about the DOM, `TODO 7`–`TODO 18`. Answers go in this file.

## Getting Started

1. Open `src/index.html` in the editor, and in Chrome or Edge by double-clicking it.
2. After each `TODO`: save, refresh the browser (**F5**), and check the result.
3. Open DevTools (**F12**) and keep the **Elements** panel handy — Parts 2 and 3 are done there.

The nav links point at pages that don't exist, so clicking them goes nowhere useful. That's expected.

---

## Part 1: Build the Page (`src/index.html`, TODOs 1–6)

Each `TODO` comment says exactly what to add and where. Write the HTML below each comment; the comments can stay.

- **TODO 1** goes inside `<head>`. When it's done, the browser tab reads "Team Directory."
- **TODO 2–3** are the heading, intro paragraph, and the navigation list. A nav menu is a list whose items each hold one link.
- **TODO 4** shows a broken-image icon and the alt text, because `logo.png` doesn't exist. That's the point of `alt`.
- **TODO 5** is the featured card. Watch the nesting: the `<span>` goes *inside* the paragraph, around just "Building B." The disabled button should appear greyed out and do nothing when clicked.
- **TODO 6** is the table. Each data row's employee id goes in its `data-employee-id` attribute, not in a cell, so the table shows three columns.

**Check Part 1:** the page shows, top to bottom, the heading and paragraph, three bulleted links, the alt text "Acme logo," the card with two buttons (one greyed out), and a three-column table with a header row and three people. In the Elements panel, every element should be nested where its `TODO` says.

## Part 2: Explore Your Page (`dom-questions.md`, TODOs 7–14)

Answer these from the **Elements** panel, not by reading the file — the point is to get comfortable reading the DOM tree. Hovering over a node highlights it on the page; expanding a node shows its children.

- **TODO 7–10** use the tree vocabulary: **parent**, **child**, **sibling**, **ancestor**. A parent is exactly one level up; an ancestor is any level up.
- **TODO 12** edits the DOM directly in DevTools, then compares it with View Page Source (Ctrl+U).
- **TODO 13** changes the *file* and refreshes.

## Part 3: A Broken Page (`dom-questions.md`, TODOs 15–18)

Open `src/broken.html`. For each question, compare the **source** (Ctrl+U) with the **Elements** panel. Every difference is something the browser repaired. A test interacts with the repaired version — the DOM — not the file.

---

## Done

The lab is complete when `index.html` matches the Part 1 check, and every question in `dom-questions.md` has an answer.
