# Lab: Selector Practice

In this lab we write CSS selectors to target specific elements on a provided help-desk page — **type, class, id, and attribute selectors**, **compound selectors**, the **descendant combinator**, **pseudo-classes** like `:nth-child`, `:not`, `:last-child`, and `:checked` — and finish by rewriting fragile, position-based selectors into durable ones. Each selector gets one obvious style so we can see exactly what it matched, and we confirm every match count in DevTools.

These are the same selectors Selenium's `By.cssSelector()` uses, so this is direct practice for UI testing.

---

## Prerequisites

| Software | Required Version |
|---|---|
| Google Chrome or Microsoft Edge | Any current version |
| A code editor (e.g., VS Code) | Any |

No installs, builds, or servers. The project is two files:

- `src/index.html` — the page we're targeting. Read it, but don't change it.
- `src/styles.css` — where we work. It contains 14 `TODO`s.

## Getting Started

1. Open `src/index.html` in Chrome or Edge by double-clicking it.
2. Open `src/styles.css` in the editor.
3. Open DevTools (**F12**) and switch to the **Console** tab.

For each `TODO`:

1. Write a complete rule below it: our selector, then the style the `TODO` gives.
2. Save the file and refresh the page (**F5**). The style shows what the selector matched.
3. Check the count in the Console, and compare it to the `TODO`'s **Expected matches**:

```javascript
$$('#search').length
```
*`$$` returns every element matching a selector. A count of exactly the expected number means the selector is right — not just close.*

Ctrl+F in the **Elements** panel also accepts a selector and highlights its matches on the page, which is handy for seeing *which* elements matched when the count is off.

---

## Part 1: Basic Selectors (TODOs 1–7)

Target single elements and groups by tag, class, id, and attribute.

- **TODO 1–3** use a type, class, and id selector respectively.
- **TODO 4** uses the element's `data-testid` attribute — the kind of hook added specifically for tests.
- **TODO 5** combines a tag with an attribute on the same element.
- **TODO 6** needs a partial attribute match (starts with).
- **TODO 7** needs one element that has *two* classes. Watch the spacing: with a space between the two classes, the selector looks for one inside the other and matches nothing.

## Part 2: Combinators and Pseudo-classes (TODOs 8–12)

Target elements by where they sit and what state they're in.

- **TODO 8**: The page has links in three places. Scope the selector so only the footer's links match.
- **TODO 9**: Each row's cells are siblings, so a pseudo-class can pick the second one in every row.
- **TODO 10**: Only the table's buttons count. A selector that isn't scoped to the table also catches the two form buttons and returns 6.
- **TODO 11**: Pick the item by its position among its siblings.
- **TODO 12**: This one matches only while the checkbox is ticked. Check the count with the box unticked (0), then ticked (1).

## Part 3: Durable Selectors (TODOs 13–14)

Each `TODO` gives a selector that works today but depends on the page's layout — the kind DevTools' **Copy selector** produces. Rewrite each one using an attribute of the element itself, so it keeps working if rows are added, removed, or re-sorted. Look at the element in `index.html` to find the right hook.

TODO 14's row is also styled by TODO 2. If our TODO 14 rule is written correctly, its blue wins over TODO 2's pink — the cascade at work.

---

## Done

The lab is complete when all 14 rules are written, every Console count matches its **Expected matches**, and each style shows up on exactly the elements its `TODO` describes.
