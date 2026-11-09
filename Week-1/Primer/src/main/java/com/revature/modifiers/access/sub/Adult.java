package com.revature.modifiers.access.sub;

import com.revature.modifiers.access.Person;

public class Adult extends Person {
    public Adult(String name, int age) {
        super(name, age);
    }

    void giveCommunityPlaygroundGreeting(){
        // communityPlaygroundMeeting can not be accessed here even though Adult inherits the method from Person
//        communityPlaygroundMeeting();
    }
}
