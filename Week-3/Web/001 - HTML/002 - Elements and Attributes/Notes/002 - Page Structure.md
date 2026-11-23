# Page Structure

Every HTML page follows the same skeleton. Recognizing it makes any page's source quick to orient in.

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Acme Store</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
  <h1>Acme Store</h1>
  <p>Welcome back.</p>
</body>
</html>
```
*The standard page skeleton: a doctype, then `<html>` containing `<head>` and `<body>`.*

## The Parts

**`<!DOCTYPE html>`** is the first line of every modern page. It isn't an element; it tells the browser to use standard rendering rules instead of an old compatibility mode.

**`<html>`** is the **root element** — the single element every other element sits inside. The `lang` attribute declares the page's language.

**`<head>`** holds information *about* the page rather than content shown on it:

- `<meta charset="UTF-8">` — the character encoding, so text displays correctly
- `<title>` — the text in the browser tab (and the page title a test can check)
- `<link rel="stylesheet">` — attaches an external stylesheet
- `<script>` — attaches JavaScript (we'll see this later in the course)

**`<body>`** holds everything visible on the page — every heading, paragraph, form, and button.

## Whitespace and Indentation

The browser collapses runs of spaces, tabs, and line breaks in content into a single space. That means indentation in the source has no effect on how the page looks — it's there purely to make the nesting readable.

```html
<p>Orders     ship
   within two business days.</p>
```
*Renders as "Orders ship within two business days." on one line. Extra spaces and line breaks collapse.*

Consistent indentation, one level per nesting level, makes the parent-child structure visible at a glance — the same structure the browser turns into the DOM tree.
