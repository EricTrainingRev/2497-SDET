package com.revature.packages;

// here the Arrays class is being imported from the java.util package
import java.util.Arrays;

public class Packages {
    /*
        In Java a significant portion of the code we work with can be used simply by referencing it (think Strings). However,
        there are many resources that require us to "import" them from other packages. This is an organization strategy
        that prevents all possible base Java code from being loaded for every application. This can also be used to generally
        organize your own code: you use packages (directories in your work space) to organize your code logically, then
        import your code where it is needed
     */

    public static void main(String[] args) {
        var myString = "Some string value";
        int[] nums = {1,2,3};
        Arrays.toString(nums);
    }

    public static void methodIWantToUseElsewhere(){
        System.out.println("This method is defined somewhere else in my code");
    }
}
