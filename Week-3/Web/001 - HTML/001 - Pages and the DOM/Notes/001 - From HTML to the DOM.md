# From HTML to the DOM

**HTML (HyperText Markup Language)** is the language web pages are written in. An HTML file describes a page's content and structure — this is a heading, this is a paragraph, this is a form with two fields. It isn't a programming language: it doesn't compute anything, it just describes what's on the page.

For testing, the most important thing to understand is what the browser *does* with that file, because a test never interacts with the HTML file itself. It interacts with the **DOM**.

## How a Page Loads

When we open a page, the browser:

1. **Downloads** the HTML file from the server (or reads it from disk).
2. **Parses** it — reads the tags from top to bottom and builds a tree of objects in memory, one object per element. That tree is the **DOM (Document Object Model)**.
3. **Downloads and applies** any CSS the page links to, deciding how each element looks.
4. **Runs** any JavaScript the page includes, which can read and change the DOM.
5. **Renders** the result on screen.

The DOM is the live, in-memory version of the page. Everything that interacts with the page — CSS selectors, JavaScript, DevTools, and test tools like Selenium — works against the DOM, not the original file.

## The Page as a Tree

Every element in the DOM sits inside another element, all the way up to the root `<html>` element. Here's a small page and the tree the browser builds from it:

```html
<html>
  <body>
    <h1>Acme Store</h1>
    <ul class="nav">
      <li><a href="/home">Home</a></li>
      <li><a href="/orders">Orders</a></li>
    </ul>
  </body>
</html>
```
*A minimal page: a heading and a two-item navigation list.*

```text
html
└── body
    ├── h1
    └── ul.nav
        ├── li
        │   └── a
        └── li
            └── a
```
*The same page as a DOM tree. Each element is a node; nesting in the HTML becomes branching in the tree.*

We describe positions in the tree with family terms:

| Term | Meaning | In the example |
|---|---|---|
| **Parent** | the element directly containing this one | `ul` is the parent of each `li` |
| **Child** | an element directly inside this one | each `li` is a child of `ul` |
| **Sibling** | an element with the same parent | the two `li` elements; also `h1` and `ul` |
| **Ancestor** | any element above this one, at any level | `body` is an ancestor of every `a` |
| **Descendant** | any element below this one, at any level | every `a` is a descendant of `ul` |

*Tree vocabulary. CSS combinators (`>` for child, a space for descendant) and next week's XPath expressions are built on exactly these relationships.*

The text inside an element is also part of the tree, as a **text node** belonging to that element — the words "Acme Store" are a text node inside the `h1`.

## The DOM Is Not the Source

The HTML file and the DOM start out the same, but they don't stay that way:

- **JavaScript changes the DOM.** Scripts add, remove, and change elements after the page loads — showing an error message, loading a list of results, opening a dialog. The file on the server never changes.
- **The browser repairs broken HTML.** Browsers never refuse to show a page because of a markup mistake. They fix it, and the DOM holds the fixed version.

That's why there are two different views of a page in the browser. **View Page Source** (Ctrl+U) shows the original file. The **Elements** panel in DevTools shows the current DOM — and the DOM is what a test sees.

## How the Browser Repairs HTML

A few repairs come up often enough to recognize:

```html
<p>First paragraph
<p>Second paragraph
```
*Missing closing tags: the browser closes the first `<p>` when the second begins, producing two sibling paragraphs.*

```html
<table>
  <tr><td>101</td><td>Login page times out</td></tr>
</table>
```
*Rows placed directly in a table: the browser inserts a `<tbody>` around them. In the DOM, each `tr` is a child of `tbody`, not of `table` — so the selector `table > tr` matches nothing.*

```html
<p>Intro text <div>A block</div></p>
```
*A `<div>` isn't allowed inside a `<p>`, so the browser closes the paragraph before the div. The DOM ends up with the paragraph, then the div as its sibling, then an extra empty paragraph from the stray `</p>`.*

If a page leaves out `<html>`, `<head>`, or `<body>` entirely, the browser adds them. The lesson for testing: when a selector doesn't match what the source suggests it should, inspect the DOM — the structure may not be what the file says.
