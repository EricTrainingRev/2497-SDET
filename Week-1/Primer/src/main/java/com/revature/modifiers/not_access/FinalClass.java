package com.revature.modifiers.not_access;

// this class can not be inherited from
public final class FinalClass {

    final static String finalString = "This reference can not be changed";

    final static void finalMethod(){
        System.out.println("This can not be overridden");
    }

}
