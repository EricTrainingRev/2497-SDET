package com.revature.classes;

public class Classes {

    /*
        Java is an Object-Oriented Language: this means all your code is going to be facilitated through the use of
        Class blueprints and Object implementations.

        Classes can have attributes (fields) and behaviors (methods). Fields are used to store references to data, and
        methods are used to perform repeatable actions that belong to the class
     */

    public static void main(String[] args) {
        var billy = new Person("Billy", 34);
        billy.greet();

        // because dogCount is class scoped we reference it via the class, not an object of the class
        System.out.println(Dog.dogCount);
        var goodBoy = new Dog("Good Boy", false);
        // Note the code below works because goodBoy is a Dog object, but it is not the expected way to access a static
        // field
        System.out.println(goodBoy.dogCount);
        var goodGirl = new Dog("Good Girl", true);
        goodBoy.barkName();
        goodGirl.barkName();
        System.out.println(Dog.dogCount);
        goodBoy.eat();
        goodGirl.eat();

    }

}
