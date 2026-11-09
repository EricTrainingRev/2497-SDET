package com.revature.modifiers.access;

public class CommunityPlayground {

    public static void main(String[] args) {
        var sally = new Kid("Sally", 8);
        System.out.println(sally.name);
        System.out.println(sally.age);
        // communityPassword can be called here because CommunityPlayground is in the same package as Person where the
        // protected method was defined
        sally.communityPassword();
        sally.communityPlaygroundMeeting();
    }

}
