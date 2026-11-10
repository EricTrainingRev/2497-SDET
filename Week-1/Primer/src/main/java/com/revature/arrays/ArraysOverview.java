package com.revature.arrays;

import java.util.Arrays;

public class ArraysOverview {

    /*
        Arrays are a built-in data structure you can use to store and move your data in your application. It is the
        simplest to use, but with that simplicity comes some restrictions. The basics of Arrays:
        - Array sizes are immutable: once an array is created its size can not be changed. If you need a larger or smaller
          array you must make a new one and transfer the old data into the new one
        - Arrays have index for the elements, and that indexing starts at 0. For instance, if you want to access the first
          element inside your array you do so via arrayVariable[0]
        - Arrays maintain order of insertion: if you put something in position 2 of your array, it stays there even as
          you move other elements around it
     */

    public static void main(String[] args) {
        /*
            String[]                -> this indicates the type for the variable is an Array that stores String data
            helloWorld              -> variable itself
            {"Hello", "world", "!"} -> each String between the curly braces is an element of the Array. This particular
                                       Array has room for 3 elements, because we placed 3 elements inside of it
         */
        String[] helloWorld = {"Hello", "world", "!"};
        // if you know how many elements need to be stored but not what those elements will be you can make an empty array
        // with x slots to hold elements. The example below holds 3 elements
        String[] helloWorld2 = new String[3];
        // to actually store the data we must assign the element to the index position
        helloWorld2[1] = "Hello";
        helloWorld2[0] = "world";
        helloWorld2[2] = "!";
        // the code below causes an ArrayIndexOutOfBoundsException because index 3 (position 4) does not exist in the Array
//        helloWorld2[3] = "Oops";

        // Arrays are basic objects: unlike more comprehensive storage solutions, like ArrayLists, you typically have to
        // do a bit of extra work to interact with the resource in the Array
        System.out.println(helloWorld2); // this prints the memory location
        // we can use the Arrays class to actually print out the content of the array.
        System.out.println(Arrays.toString(helloWorld2));

        String[] orderedAndUppercaseWords = Arrays.stream(helloWorld2)
                .sorted()
                // the two map methods below do the same thing, but the second option (the method reference) is the
                // preferred way to call a lambda expression
//                .map(word -> word.toUpperCase())
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(orderedAndUppercaseWords));
    }

}
