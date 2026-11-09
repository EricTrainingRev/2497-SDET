package com.revature.classes;

public class Dog {

    /*
        In Java all references exist in "scope". The scope of a resource determines where you can actually use that
        resource in your code. There are two dichotomies when it comes to discussing scope: Class/Object pairing, and
        the method/block paring
     */

    // this field exists in the Object (instance) scope: for every Dog object that is created it will have access to
    // its own "name" field, and can use this field in any of its methods
    String name;
    boolean hungry;

    // where Object scope keeps resources limited to the Object itself, "Class" scope (static) is a shared scope. Instead of each
    // individual object having its own version of the resource, Class scope resources are shared. They belong to the
    // Class itself, not to individual objects of the class
    static int dogCount = 0;

    public Dog(String name, boolean hungry){
        // All three options below do the same thing: increase the value of dogCount by 1
//        dogCount += 1;
//        dogCount = dogCount + 1;
        dogCount++;
        this.name = name;
        this.hungry = hungry;
    }

    void barkName(){
        System.out.println("Bark Bark! My name is " + name);
    }

    static void checkDogCount(){
        // checkDogCount and dogCount belong to the static scope, so the line below is valid
        System.out.println(dogCount + " number of dogs have been made");
        // name belongs to the instance scope, which means it CAN NOT be referenced here
//        System.out.println(name);
    }

    void eat(){
        // this not hungry message is method scoped: it can be used anywhere inside the method
        var notHungryMessage = "pitter patter";
        if(hungry){
            // our hungryMessage exists in block scope: it is only available within the code block where it was initialized
            var hungryMessage = "Nom nom nom!";
            System.out.println(hungryMessage);
        } else {
            // the reference below works because notHungryMessage is method scoped and therefor can be referenced here
            System.out.println(notHungryMessage);
            // the reference below does not work because hungryMessage is block scoped to the if statement above
//            System.out.println(hungryMessage);
        }
    }

}
