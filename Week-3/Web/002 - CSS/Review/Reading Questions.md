# CSS — Reading Questions

## How CSS Attaches

1. CSS can be written inline, in a `<style>` block, or in an external stylesheet. Why is the external stylesheet the standard choice?

2. An `id` and a `class` both label elements. How is each meant to be used, and how does that affect which one a test should rely on to find a single element?

## Selectors

1. Why is learning CSS selectors useful even for people who will never style a web page?

2. `input.required` and `input .required` differ by a single space. What does each one match, and why does the space change the meaning?

3. Some pages put attributes like `data-testid="login-submit"` on elements. Why is that a better hook for a test than a class such as `btn-primary`?

4. On the running example page, `.nav a` matches all three links, but `.nav > a` matches nothing. Why?

5. Why might `#login-form input:nth-child(2)` fail to select the second input in the form, and what's the fix?

6. `body > div:nth-child(3) > form > button` matches the right button today. Why is it still a poor selector for a test, and what makes a selector durable?

## The Cascade

1. One rule sets an input's border with `#login-form input`, and another with `.field.required`. The second selector has more parts, yet the first one wins. Why?

2. Setting `color` on `<body>` changes the text of the whole page, but setting a `border` on `<body>` draws a single box. Why the difference?

## Box Model and Visibility

1. A `.card` is given `width: 200px`, `padding: 16px`, and a `2px` border, yet it renders 236px wide. Why, and what does `box-sizing: border-box` change?

2. Setting a `width` on an `<a>` element has no effect. Why, and how do we give a link a size while keeping it in line with surrounding content?

3. `display: none`, `visibility: hidden`, and `opacity: 0` all make an element invisible. How do they differ?

4. A test finds an error message on the page, but clicking it throws an error saying the element isn't interactable. How can an element exist on the page and still not be usable?

## Browser DevTools

1. The Elements panel and **View Page Source** can show different HTML for the same page. Why, and which one reflects what a test actually interacts with?

2. When we search for a selector with Ctrl+F in the Elements panel, what should the match count be before we use it to find one element, and why check?
