# Lab: Support Request Form

In this lab we build a help-desk support request form from a spec — **text and email inputs**, **labels**, a **dropdown**, a **radio group**, a **text area**, a **checkbox with a value**, **read-only** and **disabled** fields, and all three **button types** — and then test it. Every field's behavior is checked through what the form actually sends: submitting with GET puts the **name/value pairs** in the URL, so we can compare them, character for character, against an expected result.

---

## Prerequisites

| Software | Required Version |
|---|---|
| Google Chrome or Microsoft Edge | Any current version |
| A code editor (e.g., VS Code) | Any |

No installs or servers. The lab has two files:

- `src/support.html` — the page we build the form in. It contains `TODO 1`–`TODO 10`.
- `test-results.md` — the test cases we run against the finished form (`TODO 11`).

## Getting Started

1. Open `src/support.html` in the editor, and in Chrome or Edge by double-clicking it.
2. Save and refresh (**F5**) after each `TODO` to see the field appear.
3. Submitting adds a query string to the address bar. To start fresh, delete everything from the `?` onward and press Enter, or click **Clear** once it exists.

---

## Part 1: Build the Form (`src/support.html`, TODOs 1–10)

Each `TODO` comment gives the field's label, `id`, `name`, and any values. Build them inside the form, **in the order given** — the query string lists fields in the order they appear on the page, so a different order won't match the expected results in Part 2.

- **TODO 1:** an empty `action` submits to the current page, which is what lets us read the result in the address bar.
- **TODO 2–4, 6:** connect each label to its field with `for` and `id`, and mark these required. Clicking a label should put the cursor in its field — a quick way to check the connection.
- **TODO 4:** the first option's empty value is what makes "required" work on a dropdown: "Choose one" counts as no choice.
- **TODO 5:** three radio buttons become one group only if they share a `name`. Check it: selecting one should deselect the others.
- **TODO 7:** a checkbox normally sends `on` when ticked. Giving it a `value` changes what it sends.
- **TODO 8–9:** both fields look uneditable, but they differ in whether they're submitted. Choose the attribute that matches each description.
- **TODO 10:** a `<button>` inside a form submits unless told otherwise. Give each button the right `type`.

## Part 2: Test the Form (`test-results.md`, TODO 11)

Run each test case in `test-results.md` and record what happened. The **standard test data** is:

| Field | Value |
|---|---|
| Full name | `Ada Lovelace` |
| Email | `ada@example.com` |
| Category | Technical issue |
| Description | `Export fails` |

The positive submit cases (TC01–TC02) check every field at once: if a `name` is misspelled, a field is in the wrong order, the checkbox has no `value`, or the wrong field is disabled, the query string won't match. The URL shows a space as `+` and `@` as `%40` — that's normal URL encoding.

A failing test case means the form has a defect. Fix it in `support.html`, then re-run the case.

**Optional:** change the form to `action="https://httpbin.org/post"` and `method="post"`, submit the standard test data, and find the same name/value pairs in the `"form"` section of httpbin's response. Use made-up data only — httpbin is a public test service.

---

## Done

The lab is complete when every test case in `test-results.md` has an actual result and a **Pass** status.
