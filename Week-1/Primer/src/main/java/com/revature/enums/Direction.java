package com.revature.enums;

import com.revature.oop.PolymorphismParent;

public enum Direction {
    // these are the Enum values
    UP("North"),
    DOWN("South"),
    LEFT("West"),
    RIGHT("East"),
    QUIT("quit");

//     if you want to associate a value with your Enum you need to store it in a field
//     note how above each Enum value has an associated string: that value gets stored in this field
    private String direction;

    // this provides instructions for what to do with your value: typically just set your field to the value associated
    // with your enum
    Direction (String direction){
        this.direction = direction;
    }

    // if you need to print the value then make sure to override the toString method
    @Override
    public String toString() {
        return direction;
    }

    // since Enums are just special classes you can give your enums methods.
    public void getOrientation(){
        System.out.println("I am facing a direction");
    }
}
