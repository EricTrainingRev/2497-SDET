package com.revature.annotations;

public class PersonPlayground {
    public static void main(String[] args) {
        PersonAnnotated firstPerson = new PersonAnnotated();
        PersonAnnotated secondPerson = new PersonAnnotated("Sally", 27);
        System.out.println(firstPerson.getName());
        System.out.println(firstPerson.getAge());
    }
}
