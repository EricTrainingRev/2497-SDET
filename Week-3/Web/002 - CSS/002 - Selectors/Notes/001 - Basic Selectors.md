# Basic Selectors

A **selector** is a pattern that matches elements on a page. In a stylesheet it decides which elements a rule styles, but the same syntax is used far beyond CSS: JavaScript's `document.querySelector()`, browser DevTools, and Selenium's `By.cssSelector()` all take a CSS selector. Learning selectors once pays off in all of them.

We'll use this page fragment for every example in the selector notes:

```html
<form id="login-form" class="card">
  <label for="email">Email</label>
  <input id="email" name="email" type="email" class="field required">

  <label for="password">Password</label>
  <input id="password" name="password" type="password" class="field required">

  <input name="remember" type="checkbox">
  <button type="submit" class="btn btn-primary" data-testid="login-submit">Log In</button>
</form>

<ul class="nav">
  <li><a href="/home">Home</a></li>
  <li class="active"><a href="/orders">Orders</a></li>
  <li><a href="/account">Account</a></li>
</ul>
```
*A login form and a navigation list, used as the running example.*

## Type, Class, and ID

A **type selector** is a bare tag name and matches every element of that type. A **class selector** starts with a dot and matches every element carrying that class. An **id selector** starts with a hash and matches the element with that id.

```css
input       { }  /* all three <input> elements (not the <button>) */
.field      { }  /* the email and password inputs */
.btn        { }  /* the button — it has class "btn" among others */
#password   { }  /* the one element with id="password" */
```
*Type, class, and id selectors against the login form.*

An element with several classes (`class="btn btn-primary"`) matches a selector for any one of them. Because an id should be unique, an id selector is the most precise way to target a single element — when the element has one.

## Attribute Selectors

Square brackets match on any attribute, which is invaluable when an element has no id or useful class.

```css
[type="email"]                  { }  /* exact value */
[name="remember"]               { }  /* the checkbox */
[data-testid="login-submit"]    { }  /* the button */
[disabled]                      { }  /* has the attribute at all, any value */
```
*Attribute selectors: exact match and presence.*

Attributes starting with `data-` are **custom data attributes** — HTML allows any `data-*` name. Many teams add attributes like `data-testid` specifically so tests have a stable hook that won't change when the page is restyled.

Three operators match part of a value:

| Operator | Meaning | Example | Matches |
|---|---|---|---|
| `^=` | starts with | `a[href^="/acc"]` | the Account link |
| `$=` | ends with | `a[href$="ders"]` | the Orders link |
| `*=` | contains | `[class*="prim"]` | the button (`btn-primary`) |

*Partial attribute matches. Useful when part of a value is generated or changes between builds.*

## Combining Conditions on One Element

Writing selectors back to back with **no space** means the *same* element must match all of them.

```css
input.required            { }  /* an <input> that also has class "required" */
.btn.btn-primary          { }  /* an element with both classes */
input[type="checkbox"]    { }  /* an <input> whose type is checkbox */
```
*Compound selectors: every part applies to one element.*

That missing space matters. `input.required` is "an input with the class required," while `input .required` (with a space) means "an element with class required *inside* an input" — a completely different selector, covered in the next note.

## Grouping

A comma lists separate selectors that share one rule. It means "or."

```css
#email, #password { border: 1px solid gray; }
```
*Grouping: the rule applies to the email input and to the password input.*

## Summary

| Selector | Matches |
|---|---|
| `input` | every `<input>` |
| `.field` | every element with class `field` |
| `#email` | the element with id `email` |
| `[name="email"]` | elements whose `name` attribute is `email` |
| `input.field` | `<input>` elements with class `field` |
| `#email, #password` | either element |
