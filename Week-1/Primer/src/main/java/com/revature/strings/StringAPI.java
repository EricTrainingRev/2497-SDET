package com.revature.strings;

public class StringAPI {

    /*
        Strings are your standard tool for representing text data in your application. Strings themselves are actually
        a collection of "character" data (char primitives). Because Strings are so commonly used Java has a unique
        way of storing String objects specifically. Strings are stored in the "string pool" portion of the heap. What
        makes this section unique is that Java only creates 1 object for a String value even if you make multiple
        references to that String
     */

    public static void main(String[] args) {
        /*
            In the code below we have two variables referencing the String "Hello world!" if we were to do this
            with non String data we would actually create two new objects that exist at different memory locations.
            See how the == check between the String values returns true, whereas the object == check returns false. This
            is because, by default, the "==" operator checks the memory location of the two objects being compared. The
            String variables point to the same String object, so == returns true. the two Object variables point to
            different objects, so == returns false
         */
        var helloWorldOne = "Hello world!";
        var helloWorldTwo = "Hello world!";
        System.out.println(helloWorldOne == helloWorldTwo);

        var objectOne = new Object();
        var objectTwo = new Object();
        System.out.println(objectOne == objectTwo);

        // if for some reason you wanted to make a new String object with the same text content you would have to
        // manually invoke the constructor
        var helloWorldThree = new String("Hello world!");
        System.out.println(helloWorldOne == helloWorldThree);

        /*
            Another feature of Java Strings is they are immutable: once a String is made it is "set in stone" so to speak.
            Any changes you make to a String are actually used as instructions for creating a brand-new String object in
            the String pool
         */

        helloWorldTwo = helloWorldTwo.toUpperCase();
        System.out.println(helloWorldTwo);
        System.out.println(helloWorldOne);

        /*
            If you know you are going to need to make many edits/manipulations to your String data you should use a
            StringBuilder. This class exposes tools for making "in-place" edits to your String data.
         */
        StringBuilder helloWorldbuilder = new StringBuilder("Hello World!");
        // here we add on the String content below to the original String
        helloWorldbuilder.append(" Isn't it a wonderful morning?");
        System.out.println(helloWorldbuilder);
        // here we find where the "wonderful" substring starts in our text
        int substringStart = helloWorldbuilder.indexOf("wonderful");
        System.out.println(substringStart);
        // here we remove the "wonderful" sub string from our StringBuilder
        helloWorldbuilder.replace(substringStart, substringStart+10, "");
        System.out.println(helloWorldbuilder);
        // note how, other than pulling out the index start of the sub string, everything is happening in-place: there
        // is no need to reassign the variable holding our StringBuilder to a brand new String Builder

    }

}
