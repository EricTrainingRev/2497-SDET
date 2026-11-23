# Display and Visibility

The `display` property decides how an element takes up space — or whether it takes up any at all. For anyone testing a page, it also explains a common puzzle: an element is clearly in the HTML, yet a test can't see it or click it.

## Block and Inline

A **block** element starts on a new line and stretches to the full width available. An **inline** element flows within a line of text and is only as wide as its content.

| Default display | Elements |
|---|---|
| `block` | `<div>`, `<p>`, `<h1>`–`<h6>`, `<form>`, `<ul>`, `<li>`, `<section>` |
| `inline` | `<span>`, `<a>`, `<strong>`, `<em>`, `<label>` |

*Common elements and their default display. CSS can change any of them.*

Inline elements ignore `width`, `height`, and vertical margin. When something needs to sit in a line but still have a size — a button-styled link, for instance — `display: inline-block` gives it both.

```css
a.btn {
  display: inline-block;
  padding: 8px 16px;
}
```
*Turning a link into a sized, padded button that still sits in line with other content.*

## Hiding Elements

There are three common ways to hide an element, and they behave differently:

| CSS | Visible? | Takes up space? | Can be clicked? |
|---|---|---|---|
| `display: none` | No | No — removed from the layout | No |
| `visibility: hidden` | No | Yes — leaves an empty gap | No |
| `opacity: 0` | No | Yes | **Yes** — still receives clicks |

*Three ways to hide an element. Only `display: none` removes it from the layout entirely.*

HTML's `hidden` attribute (`<div hidden>`) is shorthand for `display: none`.

```css
.error-message { display: none; }            /* hidden until... */
.error-message.visible { display: block; }   /* ...JavaScript adds the "visible" class */
```
*A common pattern: an element is always in the HTML, and JavaScript shows or hides it by toggling a class.*

## Why This Matters for Testing

A hidden element is still part of the page's HTML. That leads to a frequent surprise in automated tests: a selector **finds** the element, but the test can't use it.

- In Selenium, clicking an element hidden with `display: none` or `visibility: hidden` throws an `ElementNotInteractableException`.
- An element can be visible yet **covered** by another one, such as a loading overlay or a pop-up. Clicking it then throws an `ElementClickInterceptedException`, because the click would land on the element on top.
- Error messages, modals, and dropdown menus are usually present all along and only become visible after some action, so a test often has to wait for visibility rather than existence.

When a test can't interact with an element it can find, inspecting that element's `display`, `visibility`, and `opacity` in DevTools is the first thing to check.
