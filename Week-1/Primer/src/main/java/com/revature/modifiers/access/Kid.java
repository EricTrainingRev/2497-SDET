package com.revature.modifiers.access;

public class Kid extends Person {


    public Kid(String name, int age) {
        super(name, age);
    }

    /*
        Access modifiers control where resources in your code can be accessed. There are four different access modifiers
        you can use to control access to your resources:
        - public: public resources can be accessed anywhere in your code. Use this modifier for public facing code you write
        - protected: protected resources can be accessed by child classes and within the same package
        - default: if no access modifier is provided then the resource is given the "Default" access modifier. This makes it
                   so only resources in the same package can access the default modified resource
        - private: private resources can only be accessed within the class where they were defined
     */

    public void shareSecretPassword(){
        System.out.println("Here is my secret community password:");
        communityPassword();
    }

    void shareSocialSecurityNumber(){
        // the code below does not work because socialSecurityNumber is private, so it can not be accessed here
//        System.out.println("My social security number is " + socialSecurityNumber);
    }

}
