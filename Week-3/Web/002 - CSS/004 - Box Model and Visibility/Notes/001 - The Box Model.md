# The Box Model

Every HTML element renders as a rectangular box made of four layers, from the inside out:

- **Content** — the text, image, or child elements themselves
- **Padding** — space between the content and the border, inside the element's background
- **Border** — a line around the padding
- **Margin** — space outside the border, separating the element from its neighbors

```css
.card {
  width: 200px;
  padding: 16px;
  border: 2px solid black;
  margin: 20px;
}
```
*A `.card` box. Its visible width is more than 200px once padding and border are added.*

## How Width Is Calculated

By default, `width` and `height` set only the **content** layer. Padding and border are added on top, so the box above is 200 + 16 + 16 + 2 + 2 = **236px** wide, plus 20px of margin on each side.

That default surprises almost everyone, so most stylesheets switch it off with `box-sizing: border-box`. With it, `width` includes the padding and border, and the content shrinks to fit.

```css
.card {
  box-sizing: border-box;
  width: 200px;   /* the visible box is now exactly 200px */
}
```
*With `border-box`, padding and border are carved out of the declared width instead of being added to it.*

## Shorthand Values

`margin` and `padding` accept one to four values, going clockwise from the top.

```css
margin: 10px;                  /* all four sides */
margin: 10px 20px;             /* top and bottom 10px, left and right 20px */
margin: 10px 20px 5px 0;       /* top, right, bottom, left */
```
*Margin and padding shorthand. One value applies everywhere; four go top, right, bottom, left.*

In DevTools, selecting an element shows a box model diagram with the actual pixel size of each layer, which is the fastest way to see where unexpected space is coming from.
