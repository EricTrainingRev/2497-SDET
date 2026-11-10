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

    // if you are ever unsure of how many arguments will be provided to your method you can use a variable argument (var arg)
    // to store however many arguments are provided to your method at runtime. They are saved in an array and then you can
    // access them through the array. If you use a var arg it must be the last parameter declared
    static int addAllTheNumbers(int... nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return sum;
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

        int sumOfAllNumbers = addAllTheNumbers(1,2,3,4,5);
        System.out.println(sumOfAllNumbers);
        int sumOfAllNumbers2 = addAllTheNumbers(6,7,8,9);
        System.out.println(sumOfAllNumbers2);

    }



}
