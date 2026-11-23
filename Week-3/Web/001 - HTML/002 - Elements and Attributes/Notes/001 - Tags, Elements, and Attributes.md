# Tags, Elements, and Attributes

## Tags and Elements

HTML marks up content with **tags**: a name in angle brackets. Most come in pairs — an **opening tag** and a **closing tag** with a slash — and everything between them is the element's content.

```html
<p>Orders ship within two business days.</p>
```
*A `<p>` (paragraph) element: opening tag, content, closing tag.*

The whole thing — tags plus content — is an **element**. Tag names aren't case-sensitive, but lowercase is the universal convention.

A few elements can't have content, so they have no closing tag. These are **void elements**, and the common ones are `<input>`, `<img>`, `<br>` (line break), `<hr>` (horizontal rule), `<meta>`, and `<link>`.

```html
<input type="email" name="email">
<img src="logo.png" alt="Acme logo">
```
*Void elements: a single tag, no closing tag. Writing `<input ... />` with a trailing slash is also accepted.*

## Nesting

Elements go inside other elements, and they must close in the reverse order they opened — like parentheses.

```html
<p>Call <strong>today</strong> to order.</p>      <!-- correct -->
<p>Call <strong>today</p> to order.</strong>      <!-- wrong: overlapping -->
```
*Correct nesting closes the inner element first. Overlapping tags produce a DOM the browser had to guess at.*

The parts of the page that look like `<!-- ... -->` are **comments**. They're ignored by the browser and don't appear on the page.

## Attributes

**Attributes** add information to an element. They go inside the opening tag as `name="value"` pairs, separated by spaces.

```html
<a href="/orders" class="nav-link active" id="orders-link">Orders</a>
```
*A link with three attributes: where it goes (`href`), two classes, and an id.*

Some attributes are **boolean**: their presence alone means "true," and they don't need a value.

```html
<button disabled>Sold Out</button>
<input type="checkbox" checked>
```
*Boolean attributes. Writing `disabled="false"` still disables the button — only removing the attribute turns it off.*

## Attributes Testers Rely On

Attributes are what tests use to find and check elements. These come up constantly:

| Attribute | Purpose | Example |
|---|---|---|
| `id` | A unique name for one element on the page | `id="email"` |
| `class` | Reusable labels, space-separated; mainly for styling | `class="btn btn-primary"` |
| `name` | Identifies a form field's data when the form is submitted | `name="email"` |
| `data-*` | Custom data; often added just for tests | `data-testid="login-submit"` |
| `type` | The kind of input or button | `type="password"` |
| `value` | A field's current or default value | `value="open"` |
| `href` | A link's destination | `href="/orders"` |
| `disabled` | The element can't be used or focused | `disabled` |
| `hidden` | The element isn't displayed | `hidden` |

*Attributes that come up most when locating elements and checking their state.*

An `id` should be unique on the page. Browsers don't enforce that — a page with duplicate ids still loads — which is one reason to confirm a selector matches exactly one element before relying on it.
