# Java Review — Review Questions

1. Java source is compiled once, yet the same compiled program runs on Windows, Mac, and Linux. What does the compiler produce, and which part of the process is specific to each operating system?

2. Running a Java application only requires a JRE, but writing one requires the JDK. What does the JDK add, and why does it include a JRE rather than replacing it?

3. What makes an object eligible for garbage collection? After the code below runs, which object is eligible, and why?

   ```java
   Object o1 = new Object();
   Object o2 = new Object();
   Object o3 = o1;
   o2 = o3;
   ```

4. Scope and access modifiers both limit where a name can be used. What is each one actually controlling?

5. A class has an instance variable `x` and a `static` variable `y`. If we create 100 instances, how many copies of each exist in memory? How many exist if we create none, and why?

6. `new Person()` works on a class where we never wrote a constructor. Where does that constructor come from, and why does adding a `Person(String name)` constructor make `new Person()` stop compiling?

7. Two `Person` objects built with the same name and age compare `false` with `==`. What is `==` comparing, what does the `equals` method inherited from `Object` do by default, and what has to change for equality to mean "same data"?

8. Why are we expected to override `hashCode()` whenever we override `equals()`?

9. Java is strictly pass-by-value. A method that sets `someone.age = 100` changes the caller's `Person`, but a method that sets `someone = new Person("Amy", 27)` does not. How does pass-by-value explain both results?

10. What is stored in a method's stack frame, and what is stored on the heap? Why does a local variable disappear when its method returns, while the object it referred to may live on?

11. After calling `str1.concat(" is the best!");`, printing `str1` still shows the original text. Why?

12. Two string literals `"foo"` compare `true` with `==`, but a literal compared to `new String("foo")` is `false`. Why, and what does that mean for how we should compare strings?

13. Why is building a long string with `+=` inside a loop inefficient, and how does `StringBuilder` avoid the problem?

14. Given `for (Integer i : integerList) { i *= 2; }`, are the values in `integerList` doubled when the loop finishes? Why or why not?

15. Why must a varargs parameter be the last parameter in a method, and what does the method actually receive?

16. How do packages let two libraries each define a class with the same name, such as `Date`, without conflicting?

17. Every Maven dependency is identified by its `groupId`, `artifactId`, and `version`. When we add one to `pom.xml` and build, where does Maven look for it, and why is a project's second build usually faster than its first?

18. Running `mvn package` also compiles the code and runs the tests, even though we only asked for `package`. Why?

19. `@Override` doesn't change what a method does at runtime. What does it add, and what mistake does it catch?

20. Assigning an `int` to a `double` needs no cast, but assigning a `double` to an `int` requires one. Why?

21. Why can't we turn the `String` `"42"` into an `int` with a cast, and what do we use instead?
