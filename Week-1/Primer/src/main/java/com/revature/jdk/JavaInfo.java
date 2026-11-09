package com.revature.jdk;

public class JavaInfo {

    /*
        All Java programs are going to have some shared language features
        - Java is a "high-level" programming language: this means you do not need to manually manage memory
            - Java has an automated garbage collection process
        - Java is a "statically" typed language: this means you must provide the type for your data when writing your code
            - In modern Java you can declare the type explicitly (normal) or you can use the special type "var" and have
              the compiler infer the type based upon the value assigned to your resource
        - Java is a "strongly" typed language: this means that once a reference has its type set Java can not implicitly
          change the type of the reference. This means, to put it succinctly, "once a type, always that type*"
     */

    // "main" is the entrypoint for an application: when you run your app through a class the entrypoint must be through
    // the main method
    public static void main(String[] args) {
        // STATIC TYPING
        String greeting = "Hello world!"; // the "normal" way to declare a variable
        var newGreeting = "Hello moon!"; // the "new" way to declare a variable

        // STRONG TYPING
        greeting = "Hello sun!"; // this is fine: strong typing is maintained
        // newGreeting = 100; // this is not ok: I am attempting to break my strong typing
    }

}
