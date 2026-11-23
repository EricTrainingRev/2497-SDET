# Form Controls

Forms are how users send information to an application — logging in, searching, checking out. They're also where most UI tests spend their time: typing into fields, choosing options, and clicking buttons.

## The form Element

A `<form>` groups the fields that get submitted together.

```html
<form action="/register" method="post">
  <!-- fields go here -->
</form>
```
*A form that sends its data to `/register` using a POST request. How submission works is covered in the next note.*

## Text Inputs

`<input>` is a void element whose `type` attribute decides what kind of field it is.

```html
<input type="text" name="fullName">
<input type="email" name="email">
<input type="password" name="password">
<input type="number" name="quantity" min="1" max="10">
```
*Common text-style inputs. `password` hides the characters typed; `email` and `number` check their format and range when the form is submitted.*

For multi-line text, `<textarea>` is used instead. Unlike `<input>`, it has a closing tag, and its default content goes between the tags.

```html
<textarea name="comments" rows="4"></textarea>
```
*A four-line text area.*

## Labels

A `<label>` names a field. Its `for` attribute matches the field's `id`, which connects the two: clicking the label puts the cursor in the field (or toggles a checkbox), and screen readers announce the label when the field is focused.

```html
<label for="email">Email</label>
<input id="email" type="email" name="email">
```
*A label connected to its input through `for` and `id`.*

A label can also wrap its input directly, which connects them without needing `for`:

```html
<label><input type="checkbox" name="newsletter"> Send me updates</label>
```
*A label wrapping a checkbox. Clicking the text toggles the box.*

## Checkboxes and Radio Buttons

A **checkbox** is an independent on/off choice. **Radio buttons** are a group where only one can be selected — and the group is defined by giving every radio the *same* `name`.

```html
<input type="checkbox" id="terms" name="terms">
<label for="terms">I accept the terms</label>

<input type="radio" id="ship-standard" name="shipping" value="standard" checked>
<label for="ship-standard">Standard</label>
<input type="radio" id="ship-express" name="shipping" value="express">
<label for="ship-express">Express</label>
```
*A checkbox and a two-option radio group. Both radios share `name="shipping"`, so choosing one deselects the other. `checked` sets the starting selection.*

## Dropdowns

A `<select>` is a dropdown; each choice is an `<option>`. The `value` attribute is what gets submitted; the text between the tags is what the user sees.

```html
<label for="country">Country</label>
<select id="country" name="country">
  <option value="">Choose one</option>
  <option value="us">United States</option>
  <option value="ca" selected>Canada</option>
</select>
```
*A dropdown with Canada preselected. Selecting "United States" submits `us`, not the visible text.*

## Buttons

`<button>` elements have three types, and the default surprises people:

| `type` | Clicking it |
|---|---|
| `submit` | submits the form — **the default** for a button inside a form |
| `reset` | restores every field in the form to its starting value |
| `button` | does nothing on its own; used when JavaScript handles the click |

*Button types. A `<button>` with no `type` inside a form is a submit button.*

```html
<button type="submit">Create Account</button>
<button type="button">Check Availability</button>
```
*An explicit submit button, and a plain button that won't submit the form.*

A button meant only to run some script, but missing `type="button"`, submits the form and reloads the page — a common source of "why did the page refresh?" defects.

## Field States

Three boolean attributes change how a field behaves:

- `required` — the form won't submit while this field is empty; the browser shows a message instead.
- `disabled` — the field can't be focused or changed, appears greyed out, and isn't submitted.
- `readonly` — the field can't be changed, but can be focused and *is* submitted.

```html
<input type="email" name="email" required>
<input type="text" name="promo" disabled>
<input type="text" name="accountId" value="A-1042" readonly>
```
*A required field, a disabled field, and a read-only field with a fixed value.*
