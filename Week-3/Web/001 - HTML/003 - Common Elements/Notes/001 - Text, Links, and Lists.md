# Text, Links, and Lists

A small set of elements makes up the bulk of most pages.

## Headings and Paragraphs

Headings run from `<h1>` (the main page heading) to `<h6>`, in order of importance. A page normally has one `<h1>`, with `<h2>` for sections and `<h3>` for subsections. Paragraphs of text use `<p>`.

```html
<h1>Acme Store</h1>
<h2>Featured Products</h2>
<p>New items arrive every week.</p>
```
*A main heading, a section heading, and a paragraph.*

Inside text, `<strong>` marks important text (shown in bold) and `<em>` marks emphasis (shown in italics).

## Links

The **anchor** element, `<a>`, makes a link. Its `href` attribute is the destination.

```html
<a href="https://www.example.com">Example</a>   <!-- absolute: a full address -->
<a href="/orders">Your Orders</a>              <!-- relative to the site root -->
<a href="help.html">Help</a>                   <!-- relative to the current page -->
```
*Three kinds of link. An absolute URL includes the full address; relative URLs are resolved against the current site or page.*

The text between the tags is the **link text** — what the user sees and clicks.

## Images

`<img>` is a void element. `src` is the image file, and `alt` is a text description shown if the image can't load and read aloud by screen readers.

```html
<img src="images/widget.png" alt="Blue widget, front view">
```
*An image with alternative text.*

## Lists

`<ul>` is an **unordered list** (bullets) and `<ol>` is an **ordered list** (numbers). Either way, each item is an `<li>`.

```html
<ul class="nav">
  <li><a href="/home">Home</a></li>
  <li><a href="/orders">Orders</a></li>
  <li><a href="/account">Account</a></li>
</ul>
```
*A navigation menu built as an unordered list of links — one of the most common patterns on the web.*

Menus, search results, and product listings are very often lists under the hood, which is why selectors like `.nav li` and `.nav li:first-child` come up so much.

## Grouping: div and span

`<div>` and `<span>` have no meaning of their own. They exist to group other content so it can be styled or located together. `<div>` is a **block** element (it starts on a new line); `<span>` is **inline** (it sits within a line of text).

```html
<div class="product" data-testid="product-widget">
  <h3>Widget</h3>
  <p>Only <span class="price">$19.99</span> this week.</p>
</div>
```
*A `<div>` grouping one product's content, and a `<span>` marking the price within a sentence.*

Real pages are full of nested `<div>`s, and their classes and attributes are often the only hooks a test has. Many pages also use `<header>`, `<nav>`, `<main>`, and `<footer>` the same way as `<div>`, with names that describe which part of the page they hold.
