package com.revature.modifiers.access;

import java.util.UUID;

public class Person {

    public String name;
    public int age;
    private UUID socialSecurityNumber;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
        socialSecurityNumber = UUID.randomUUID();
    }

    protected void communityPassword(){
        System.out.println("The air speed velocity of an unladen swallow is immaterial");
    }

    void communityPlaygroundMeeting(){
        System.out.println("This is our greeting for when we are at the community playground");
    }

}
