package com.revature.modifiers;

import com.revature.modifiers.access.Kid;

public class Playground {

    public static void main(String[] args) {
        var sally = new Kid("Sally", 8);
        System.out.println(sally.name);
        System.out.println(sally.age);
        sally.shareSecretPassword();
        // the communityPassword can not be directly called here since it is protected
//        sally.communityPassword();
        sally.socialSecurityNumber;
    }

}
