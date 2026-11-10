package com.revature.control;

public class Conditionals {

    /*
        Most Java applications are not simple linear flows of execution: they require checking conditions, updating
        state, redoing actions, etc. Java provides many options for how to control the flow of your application; the
        simplest of these is your if-else statements. "if" blocks allow you to check one or more logical conditions
        and determine what branch of code to execute based on the condition
     */

    public static void main(String[] args) {
//        System.out.println(basicIfCheck(10));
//        System.out.println(basicIfCheck(11));
//        System.out.println(ifElseBlock(20));
//        System.out.println(ifElseBlock(15));
        System.out.println(ifElseIfElseBlock(20));
        System.out.println(ifElseIfElseBlock(15));
        System.out.println(ifElseIfElseBlock(10));
    }

    static String basicIfCheck(int number){
        var isEven = "Even";
        // if the logical check made below results in a "true" boolean the associated code block will execute
        if(number % 2 != 0){
            isEven = "Odd";
        }
        return isEven;
    }

    static String ifElseBlock(int age){
        /*
            You can set up if-else blocks when you know you want one of two flows of execution to trigger with your code.
            If the if statement results in a true boolean its associated block will execute, but if it results in a false
            boolean then the else block triggers instead
         */
        if(age >= 18){
            return "You are allowed to vote!";
        } else {
            return "You are not yet old enough to vote";
        }
    }

    static String ifElseIfElseBlock(int age){
        /*
            If you have multiple conditions to check you can chain "else if" blocks after your initial if statement. Keep
            in mind the first logical check that passes is the one that is executed: no other checks are made in the chain.
            This means you need to prioritize your logical checks and their associated code if you ever make a chain like
            this
         */
        String message;
        if(age >= 18){
            message = "Enjoy the movie!";
        } else if (age >= 13 && age <= 17){
            message = "Do you have a parent with you?";
        }
        // NOTE: the else block is not actually mandatory to include, but it can be useful for setting a fallback action
        // if none of the if checks are met
        else {
            message = "you are too young to watch movies young one!";
        }
        return message;
    }

}
