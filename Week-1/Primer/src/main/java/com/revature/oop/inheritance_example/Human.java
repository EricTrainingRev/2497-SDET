package com.revature.oop.inheritance_example;

public abstract class Human {

    /*
        Anytime you have a class that is only acting as a carrier of data for inheritance it is worth making it an
        "abstract" class. What this means is you can add attributes and behaviors like normal, but you can also
        add "abstract" methods to the class, which can not normally be done. Abstract methods in abstract classes
        work exactly like they do in interfaces: they must be implemented in the inheriting class
     */

    private String name;
    private String age;

    public Human(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void eat(){
        System.out.println("nom nom nom");
    }

    // this tells our code "Human" objects can speak, but how that speaking works is determined by the inheriting
    // class
    public abstract void speak();
}
