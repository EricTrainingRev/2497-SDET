package com.revature.oop;

import java.util.ArrayList;
import java.util.List;

public class Abstraction {

    /*
        The basic idea behind "Abstraction" is that you don't need to know how something works in order to use it. The
        complexity of implementation, relationship, etc., does not need to be exposed to the developer or the application
        in order for the code to work. Things can "just work"
     */

    public static void main(String[] args) {
        /*
            Think about the code below: how much of what is happening below do you really deeply understand? Can you
            explain, line by line, how the constructor builds the Arraylist? Can you walk through the steps of the add
            method, or getFirst? The reality is we don't need to understand deeply how these methods and resources work,
            we just need to know how to implement them. This is the beauty of Abstraction: things can "just work" in
            Object-Oriented Program, and the complexity of how those things work can be hidden, or "abstracted away".
         */
        ArrayList<String> myNames = new ArrayList<>();
        myNames.add("Sally");
        System.out.println(myNames.getFirst());
    }

}
