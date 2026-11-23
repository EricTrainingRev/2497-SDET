# Specificity and Order

Several rules often match the same element and set the same property to different values. The **cascade** is the set of rules the browser uses to pick a winner. We only need enough of it to answer one practical question: "why isn't this style applying?"

## How a Winner Is Picked

When two declarations conflict, the browser compares them in this order and stops at the first difference:

1. **Importance** — a declaration marked `!important` beats normal ones. It's a blunt override and generally a sign of a styling problem, so we just need to recognize it.
2. **Specificity** — the more specific selector wins.
3. **Source order** — if specificity is tied, the rule that appears later wins.

## Specificity

**Specificity** scores a selector by counting three kinds of components:

- **IDs** (`#login-form`)
- **Classes, attributes, and pseudo-classes** (`.field`, `[type="email"]`, `:first-child`)
- **Element types** (`input`, `li`)

The counts are compared left to right, like version numbers: one ID outweighs any number of classes, and one class outweighs any number of element types.

| Selector | IDs | Classes / attributes / pseudo-classes | Types |
|---|---|---|---|
| `input` | 0 | 0 | 1 |
| `.field` | 0 | 1 | 0 |
| `input.field` | 0 | 1 | 1 |
| `#login-form input` | 1 | 0 | 1 |
| `#login-form .field` | 1 | 1 | 0 |

*Specificity of increasingly specific selectors. Each row beats every row above it.*

Inline styles (the `style` attribute) beat any selector in a stylesheet.

```css
#login-form input { border-color: gray; }   /* 1-0-1: wins */
.field.required   { border-color: red; }    /* 0-2-0 */
```
*The ID-based rule wins even though the class rule has more parts — one ID outweighs two classes.*

## Source Order

When specificity ties, the later rule wins. That includes the order stylesheets are loaded: rules from a `<link>` that comes after another stylesheet in the `<head>` override equally specific rules from the earlier one.

```css
.btn { background-color: gray; }
.btn { background-color: blue; }   /* wins: same specificity, comes later */
```
*Two equally specific rules. The second one wins.*

## Inheritance

Some properties, mostly text-related ones like `color` and `font-family`, are **inherited**: set them on a parent and every descendant picks them up unless something overrides it. Box-related properties like `border`, `margin`, and `padding` are not inherited. That's why setting `color` on `<body>` changes the text of the whole page, while setting a `border` on `<body>` draws one box.

In the browser's DevTools, the Styles pane lists every rule that matches the selected element, with overridden declarations shown in strikethrough — the quickest way to see the cascade's decision.
