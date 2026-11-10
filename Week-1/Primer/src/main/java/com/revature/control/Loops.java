package com.revature.control;

public class Loops {

    /*
        Most applications that are long-lived will require some kind of loop to keep them active. Loops are also
        necessary when you need to iterate over data multiple times (think performing an action for each element in
        a collection). Java provides two primary ways of looping through data: for loops and while loops
     */

    public static void main(String[] args) {
//        forLoop(10);
        String[] words = {"Hello", "world", "!"};
        enhancedForLoop(words);
    }

    static void forLoop(int iterations){
        /*
            A standard for loop has 3 primary components:
            - int x = 0         -> this is your control variable, we use it to determine when the loop ends
            - x <= iterations   -> this is our control condition: while the statement produces a true value the loop continues
            - x++               -> this is how we update our control variable to prevent an infinite loop from running
         */
        for(int x = 0; x <= iterations; x++){
            System.out.println(x);
            if(x == 7){
                // if you ever need to end a loop early the break keyword will stop the loop
                break;
            }
        }
    }

    static void enhancedForLoop(String[] words){
        /*
            Whenever you need to iterate over a collection of data you can typically use an enhanced for loop

            String word -> this is a variable that represents the data for the current iteration
            words       -> this is the collection we are iterating through

            Once each element of the collection has gone through the loop it automatically ends
         */
        for(String word : words){
            if(word.equals("Hello")){
                // continue tells your loop to enter its next iteration. Useful if you want to skip actions
                continue;
            }
            System.out.println(word);
            if(word.equals("world")){
                break;
            }
        }
    }

}
