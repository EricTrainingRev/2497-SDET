# HTML — Reading Questions

## Pages and the DOM

1. Tests interact with the DOM, not the HTML file the server sent. Why can those two be different?

2. In a navigation list, a link sits inside an `<li>`, which sits inside a `<ul>`. Why is the `<ul>` an *ancestor* of the link but not its *parent*, and why does that distinction matter when describing where an element is?

3. A page's source puts a `<div>` inside a `<p>`. What does the browser build in the DOM instead, and why?

## Elements and Attributes

1. A button is written as `<button disabled="false">`. Why is it still disabled?

2. A form field can have an `id`, a `class`, and a `name`. What different job does each one do?

3. What belongs in a page's `<head>` versus its `<body>`, and why might a test check something in the `<head>`?

## Common Elements

1. `href="https://www.example.com/orders"`, `href="/orders"`, and `href="orders.html"` can all point to an orders page. How does the browser work out where each one goes?

2. `<div>` and `<span>` have no meaning of their own. Why are they so common, and how do they differ?

3. HTML has elements for tables, rows, and cells, but none for columns. How is "the Total column" represented, and how do we find a value in it?

4. Why is finding a table row by its position fragile, while finding a cell by its position within a row is normal?

5. A table's rows are written directly inside `<table>`, with no `<tbody>`. What does the DOM contain, and what does that mean for anything that looks for rows as direct children of the table?

## Forms

1. What does connecting a `<label>` to its field (with `for` and `id`) actually do?

2. What turns a set of radio buttons into a group where only one can be selected? What happens if one of them is given a different `name`?

3. A user fills in every field and submits, but the server never receives the email address. The email field works normally on screen. What's the most likely cause, and why doesn't anything look wrong?

4. When a checkbox is unchecked, what does the form send for it? What does it send when checked?

5. A "Check Availability" `<button>` inside a form reloads the page when clicked. Why, and what's the fix?

6. `disabled` and `readonly` both stop a user from changing a field. How do they differ when the form is submitted?

7. With GET, form data appears in the URL; with POST, it doesn't. Where does it go with POST, and why do login forms use POST?
