package com.revature.methods;

public class Methods {

    /*
        In Java methods are the mechanism by which you define repeatable actions in your code. Methods are attached
        to Classes and can be instanced or class scoped.

        consider the method below

        public: access modifier
        void: this is the return type. Void indicates the method does not return any data
        doSomething: this is the name of the method. We invoke the method via its name
        (String arg): this is the parameter of the method. Methods can have multiple parameters
        {}: the actual code to be executed when the method is called
     */

    public void doSomething(String arg){
        System.out.println(arg);
    }

    // in this case doMath returns an int value: the method MUST return an int, or it must throw an exception
    private int doMath(int numOne, int numTwo){
        return numOne + numTwo;
    }

    // the main method is a regular method: you can call it just like any other. That being said, it is normal to have
    // Java run it for you. the "args" parameter in the main method holds any flags/command line arguments provided
    // to the app at runtime
    public static void main(String[] args) {
        for(String arg : args){
            System.out.println(arg);
        }
        Methods obj = new Methods();
        // to call a method use the dot operator and reference the method you want to invoke
        obj.doSomething("Hello world!");
        int result = obj.doMath(5,6);

    }



}
