# CSS Rules and Stylesheets

A web page is built from three layers, each with one job. **HTML** defines the structure and content — headings, forms, buttons. **CSS (Cascading Style Sheets)** defines how that content looks — colors, spacing, sizes, visibility. **JavaScript** defines behavior — what happens when someone clicks or types. Keeping the layers separate means we can restyle a page without touching its structure, and vice versa.

We won't be designing pages. What matters for us is reading CSS well enough to understand why a page looks the way it does — and, most of all, learning **selectors**, the pattern language CSS uses to target elements. The same selectors are used by JavaScript and by test automation tools like Selenium to find elements on a page.

## Anatomy of a Rule

A stylesheet is a list of **rules**. Each rule pairs a **selector** (which elements) with a block of **declarations** (what to do to them). Each declaration is a **property** and a **value**, ending in a semicolon.

```css
/* selector */
.error-message {
  color: red;          /* declaration: property + value */
  font-weight: bold;
}
```
*A rule that makes every element with the class `error-message` red and bold. Comments use `/* ... */`.*

A handful of properties cover most of what we'll see: `color`, `background-color`, `font-size`, `margin`, `padding`, `border`, `width`, `height`, and `display`.

## Three Ways to Add CSS to a Page

**Inline** styles go directly on one element through its `style` attribute. They affect only that element and are the hardest to maintain, since the styling is scattered through the HTML.

```html
<p style="color: blue;">Inline styled text</p>
```
*An inline style: applies to this one paragraph only.*

An **internal** (embedded) stylesheet is a `<style>` block in the page's `<head>`. It applies to the whole page, but only that page.

```html
<head>
  <style>
    p { color: blue; }
  </style>
</head>
```
*An internal stylesheet: every paragraph on this page turns blue.*

An **external** stylesheet is a separate `.css` file, linked from each page's `<head>`. This is the standard approach: one file styles every page of a site, there's one place to make changes, and the browser downloads and caches it once.

```html
<head>
  <link rel="stylesheet" href="styles.css">
</head>
```
*Linking an external stylesheet. The rules live in `styles.css`.*

A page can use all three at once. When they disagree, inline styles generally win — the rules for deciding are covered in [the cascade](../../003%20-%20The%20Cascade/Notes/001%20-%20Specificity%20and%20Order.md).

## Classes and IDs Are the Hooks

CSS rarely targets elements by tag alone; it targets the `class` and `id` attributes developers put on the HTML.

```html
<button id="checkout" class="btn btn-primary">Check Out</button>
```
*One element with an `id` and two classes. Classes are space-separated, so this button has both `btn` and `btn-primary`.*

An **id** should be unique on the page and identifies one specific element. A **class** is a reusable label that any number of elements can share, and one element can have several. These attributes are the same hooks a test uses to find an element — which is why reading a page's HTML and CSS goes hand in hand with writing selectors.
