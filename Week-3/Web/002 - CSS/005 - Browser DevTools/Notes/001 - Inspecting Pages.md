# Inspecting Pages

Every major browser ships with **developer tools** (DevTools) for looking inside a live page. For our purposes they answer three questions: what is this element, why does it look the way it does, and does my selector find it? The steps below use Chrome; Edge is identical, and Firefox is very similar.

## Opening DevTools

- Right-click any element on the page and choose **Inspect** — this opens DevTools with that element selected.
- Or press **F12** or **Ctrl+Shift+I** (**Cmd+Option+I** on Mac).

## The Elements Panel

The **Elements** panel shows the page's **DOM (Document Object Model)** — the tree of elements the browser built from the HTML. It's the *live* page: if JavaScript has added, removed, or changed elements since the page loaded, the Elements panel shows the current state. **View Page Source** (Ctrl+U) shows the original HTML file instead, which can differ.

Hovering over a node highlights the element on the page, and clicking the arrow icon at the top-left of DevTools lets us click an element on the page to jump to it in the tree.

## The Styles Pane

With an element selected, the **Styles** pane lists every CSS rule that matches it, most specific first, along with the file and line each rule came from.

- Declarations that lost to another rule are shown in ~~strikethrough~~ — the cascade's decision, made visible.
- Clicking a value lets us edit it live; the checkbox next to each declaration toggles it off and on. Changes disappear on reload.
- The **:hov** button forces states like `:hover` and `:focus`, so we can inspect styles that otherwise only appear while the mouse is over an element.

The **Computed** tab shows the final value of every property after the cascade, plus the box model diagram with real pixel sizes. Checking `display`, `visibility`, and `opacity` here is the quickest way to find out why an element isn't visible.

## Testing a Selector

Before a selector goes into code or a test, we can check it against the live page.

**In the Elements panel**, press **Ctrl+F** (Cmd+F on Mac). The search box accepts a CSS selector, highlights each match, and shows a count like "1 of 3." A selector meant to find one element should show **1 of 1**.

**In the Console**, two helpers built into DevTools run a selector directly:

```javascript
$$('.nav a')                       // an array of every match
$('[data-testid="login-submit"]')  // the first match
```
*`$$` and `$` are DevTools shortcuts for `document.querySelectorAll` and `document.querySelector`.*

If a page loads its own library that uses `$` (such as jQuery), `$` means that library's function instead; `document.querySelector` always works.

## Copy Selector

Right-clicking a node in the Elements panel and choosing **Copy → Copy selector** generates a selector for that element. It's handy as a starting point, but it often produces a long positional chain like `#main > div:nth-child(2) > form > button` — exactly the fragile kind of selector that breaks when the layout changes. Treat it as a hint, then rewrite it around an id or a stable attribute.

## A Selector Workflow

1. Right-click the element and **Inspect** it.
2. Look for a stable hook: an `id`, a `data-testid`, a `name`, or a meaningful class.
3. Write the shortest selector built on that hook.
4. Confirm it with Ctrl+F in the Elements panel: **1 of 1**.
