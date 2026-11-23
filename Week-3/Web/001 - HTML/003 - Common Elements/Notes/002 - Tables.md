# Tables

Tables show data in rows and columns — order histories, search results, admin lists. They're one of the most common things a UI test has to read: find the row for a particular record, then check a value in it or click a button in it.

## Structure

```html
<table id="orders">
  <thead>
    <tr>
      <th>Order</th>
      <th>Date</th>
      <th>Total</th>
    </tr>
  </thead>
  <tbody>
    <tr data-order-id="5001">
      <td>5001</td>
      <td>2026-11-02</td>
      <td>$58.40</td>
    </tr>
    <tr data-order-id="5002">
      <td>5002</td>
      <td>2026-11-09</td>
      <td>$12.99</td>
    </tr>
  </tbody>
</table>
```
*An orders table with a header row and two data rows.*

| Element | Role |
|---|---|
| `<table>` | the whole table |
| `<thead>` | the header section (column titles) |
| `<tbody>` | the body section (the data rows) |
| `<tr>` | a **table row** |
| `<th>` | a **header cell**, usually bold and centered |
| `<td>` | a **data cell** |

*Table elements. Rows contain cells; cells never sit directly in a table.*

The structure is always rows first, then cells: a `<tr>` contains `<th>` or `<td>` elements, one per column. Columns aren't elements at all — "the Total column" is just the third cell of every row.

## A Missing tbody Is Added

If a table's rows are written directly inside `<table>`, the browser inserts a `<tbody>` around them in the DOM. In the DOM, rows always live inside `<thead>` or `<tbody>` — so a selector written as `table > tr` matches nothing, while `table tr` (descendant, any depth) works either way.

## Locating Things in a Table

A row is usually found by something unique in it — an id, a data attribute, or the text of one of its cells. A value in that row is then found by its position among the row's cells.

```css
#orders tbody tr                       /* every data row */
#orders tr[data-order-id="5002"]       /* one specific row */
#orders tbody td:nth-child(3)          /* the Total cell of every row */
#orders tr[data-order-id="5002"] td:nth-child(3)   /* one row's Total */
```
*Selectors for rows and cells. A stable attribute picks the row; a position picks the column.*

Picking a row by its *position* (`tr:nth-child(2)`) is fragile, since sorting or adding a record changes which row is second. Picking a cell by position within a row is normal, because the column order is part of the table's design.
