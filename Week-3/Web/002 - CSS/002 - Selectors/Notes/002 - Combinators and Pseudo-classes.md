# Combinators and Pseudo-classes

Basic selectors describe a single element. **Combinators** describe an element by its position relative to others, and **pseudo-classes** describe an element by its state or position among its siblings. Together they let us target elements that have no unique id or class of their own. These examples use the login form and navigation list from [Basic Selectors](001%20-%20Basic%20Selectors.md).

## Combinators

| Combinator | Name | Example | Matches |
|---|---|---|---|
| space | descendant | `#login-form input` | any `<input>` anywhere inside the form |
| `>` | child | `ul.nav > li` | `<li>` elements directly inside the list |
| `+` | adjacent sibling | `label + input` | an `<input>` immediately after a `<label>` |
| `~` | general sibling | `#email ~ input` | any `<input>` after `#email` with the same parent |

*The four combinators.*

The **descendant** combinator (a space) is the one we'll use most. It matches at any depth: `.nav a` finds the links even though each one sits inside an `<li>`. The **child** combinator (`>`) only looks one level down: `.nav > a` matches nothing, because the links aren't direct children of the `<ul>`.

```css
.nav a         { }  /* all three links — any depth */
.nav > li      { }  /* all three list items — direct children */
.nav > a       { }  /* nothing — no <a> is a direct child of the <ul> */
```
*Descendant vs. child against the navigation list.*

## Pseudo-classes

A **pseudo-class** starts with a colon and narrows a selector by state or position.

```css
.nav li:first-child     { }  /* the Home item */
.nav li:last-child      { }  /* the Account item */
.nav li:nth-child(2)    { }  /* the Orders item (counting starts at 1) */
.nav li:not(.active)    { }  /* Home and Account */
input:checked           { }  /* the checkbox, only while it's checked */
button:disabled         { }  /* a button with the disabled attribute */
a:hover                 { }  /* a link while the mouse is over it */
```
*Common pseudo-classes for position and state.*

Two cautions. `:nth-child(n)` counts *all* siblings regardless of type, so `#login-form input:nth-child(2)` may not mean "the second input" — use `:nth-of-type(2)` when only elements of the same type should be counted. And `:hover` is purely for styling; it matches only while a mouse is physically over the element.

## Writing Selectors That Last

Most selectors we write outside of styling are for finding one specific element — in a script or a test. A good one is **unique** (matches exactly one element) and **stable** (still matches after the page is redesigned).

```css
/* Fragile: depends on the exact page layout */
body > div:nth-child(3) > form > button

/* Stable: depends on the element itself */
[data-testid="login-submit"]
#login-form button[type="submit"]
```
*A positional chain breaks when any wrapper is added or moved. Selectors based on the element's own attributes survive redesigns.*

In order of preference: an `id`, a dedicated test attribute like `data-testid`, a meaningful attribute (`name`, `type`), then a short class-based selector. Long chains of positions and `:nth-child` are the last resort.

## Selectors Outside of CSS

Everything above works unchanged in JavaScript and in test automation:

```javascript
document.querySelector('#login-form .field');        // first match
document.querySelectorAll('.nav a');                 // every match
```
*JavaScript in the browser takes the same selector strings.*

```java
driver.findElement(By.cssSelector("[data-testid='login-submit']")).click();
```
*Selenium (coming up next week) finds elements with the same CSS selector syntax.*
