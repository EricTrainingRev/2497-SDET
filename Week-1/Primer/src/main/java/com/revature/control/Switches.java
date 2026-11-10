package com.revature.control;

public class Switches {

    /*
        Switch statements are useful when you need to do pattern matching or facilitate various operations based
        upon some controlling data. So it's less about performing an operation based on a logical condition, more so
        perform x action based on y data
     */

    public static void main(String[] args) {

        var userInput = "w";

        // this indicates we are making a switch statement: we must provide a value that will be matched against vairous
        // "cases". Once a case is found that matches, going from first last, ALL following cases will trigger unless you
        // break out of the switch statement
        switch (userInput){
            case "w":
                System.out.println("User moves up");
                break;
            case "a":
                System.out.println("user moves left");
                break;
            case "s":
                System.out.println("user moves down");
                break;
            case "d":
                System.out.println("user moves right");
                break;
            default:
                System.out.println("user does something besides moving");
        }



    }

}
