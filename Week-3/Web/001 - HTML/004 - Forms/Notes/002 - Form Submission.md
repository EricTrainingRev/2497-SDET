# Form Submission

Submitting a form sends its data to a server as a set of **name/value pairs**. Knowing exactly what gets sent — and what doesn't — explains a lot of form behavior, and a lot of form defects.

## Name/Value Pairs

When a form is submitted, the browser collects every field that has a `name`, pairs that name with the field's current value, and sends the list to the URL in the form's `action`.

```html
<form action="/search" method="get">
  <input type="text" name="q" value="widget">
  <select name="sort">
    <option value="price">Price</option>
    <option value="newest" selected>Newest</option>
  </select>
  <button type="submit">Search</button>
</form>
```
*A search form with two named fields.*

Submitting it sends two pairs: `q=widget` and `sort=newest`. The labels, the visible option text, and the button aren't sent — only named fields and their values.

## What Gets Sent

| Field | What's submitted |
|---|---|
| Text, email, password, number, textarea | `name=` whatever is typed (an empty value is still sent) |
| Select | `name=` the chosen option's `value` |
| Radio group | `name=` the `value` of the selected radio — nothing if none is selected |
| Checkbox | `name=on` (or its `value`) when checked — **nothing at all when unchecked** |
| Field with no `name` | **nothing** |
| `disabled` field | **nothing** |

*What each kind of field contributes. The three "nothing" cases cause most missing-data defects.*

A field without a `name` looks and works normally on screen — the user can type in it — but its data silently never reaches the server. When a submitted value is missing, a missing or misspelled `name` is the first thing to check.

## GET and POST

The form's `method` decides where the pairs travel.

With **`method="get"`**, the pairs are added to the URL as a **query string**: a `?`, then pairs joined with `&`.

```text
/search?q=widget&sort=newest
```
*The URL after submitting the search form with GET. Spaces in values become `+`, and other special characters are encoded.*

With **`method="post"`**, the pairs travel in the **body** of the request instead, so they don't appear in the URL. The **Network** tab in DevTools shows the request and its form data either way.

GET is used for requests that only read data — searches and filters — since the resulting URL can be bookmarked and shared. POST is used for anything that changes data or includes sensitive values: logins, registrations, purchases. A login form using GET would put the password in the URL, browser history, and server logs.

If a form has no `action`, it submits to the current page's URL. If it has no `method`, it uses GET.

## Ways a Form Gets Submitted

A form submits when the user:

- clicks a submit button — including any `<button>` with no `type`
- presses **Enter** while focused in one of its text fields

Before sending anything, the browser checks the built-in rules — `required` fields, `type="email"` formats, `min` and `max` on numbers. If any check fails, the form isn't submitted and the browser shows a message on the first problem field.
