package com.revature;

public class Calculator {

    public static String divide(float numOne, float numTwo){
        if(numTwo == 0){
            throw new ArithmeticException("Can't divide by zero");
        }
        float result = numOne / numTwo;
        return Float.toString(result);
    }

}
