package com.revature.memory;

public class StackAndHeap {

    /*
        In Java there are two primary memory regions that store different types of data
        - Heap: this is where Object data is stored
        - Stack: this is where primitive (non-object data) and method stacks are stored
     */

    public static void main(String[] args) {
        // this creates a String with the value of "Billy" and stores it in the heap
        var billy = "Billy";
        // this creates a primitive value of 20 which stays in the stack
        int age = 20;
        // this creates a stack frame: this actions of this frame must be handled before the main frame can continue
        // execution
        createAStack(billy);
    }

    public static void createAStack(String arg){
        // inside of createAStack note we have another method call: this call also creates a frame stack that must resolve
        // before the createAStack frame can itself be resolved
        System.out.println(arg);
    }

}
