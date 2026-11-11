package com.revature.collections;

import java.util.*;

public class CollectionPlayground {

    /*
        The Collection API is a reference to the more common data structures you will use in Java. There are four
        interfaces that the most common data structures implement
        - List
        - Set
        - Queue
        - Map*

        Each of these different structures is useful for a different set of tasks

        Lists are the generalists of these collections: they are the most flexible data structures, and will serve just
        fine for most use-cases you will have for storing data in your code. A few key features
        - Lists are indexable
        - Lists respect order of insertion
        - Lists allow duplicate values

        Sets are useful when you need to work with unique values. Unlike lists which store general data, Sets are more
        specialized:
        - Sets are not indexable
        - Sets do not necessarily respect order of insertion
        - Sets do not allow duplicate data

        The Queue interface, and more so now the Deque interface, provides the ability to facilitate First-in-First-Out
        and Last-in-First-Out operations. Consider using this type of data structure when the order of insertion matters
        for determining what element should be interacted with "next"

        Map does not implement the Collection Interface, but Maps are so commonly used they get included in the conversation.
        Maps are how you create key-value pairs in your code. You set the key type, the value type, and then you can
        put those pairing in your Map
     */

    public static void main(String[] args) {

//        showcaseLists();
//        showcaseSets();
//        showcaseQueues();
//        showcaseMaps();
    }

    static void showcaseLists(){
        /*
            A common pattern you will see in Java is setting the type of your variable as an interface, but then making
            an object that implements that interface. The benefit of this is it allows you to swap your implementation
            class when needed (Note, you can not cast, change the type of the object, between them)
         */
        List<Integer> myNums = new ArrayList<>();
        myNums.add(1);
        myNums.add(2);
        // we can see with the print below the order of insertion is respected, 1 is first, 2 is second
        System.out.println(myNums);
        myNums.addFirst(0);
        System.out.println(myNums);
        // we can access elements by their index position
        System.out.println(myNums.get(1));
        // we can add duplicate values and they are kept in the list
        myNums.add(1);
        System.out.println(myNums);
    }

    static void showcaseSets(){
        /*
            Note how after the Set type we have a class reference between <>. Here we are providing a "Generic" value.
            This type tells Java what kind of data is stored within the Set. The common convention for writing this is
            to include the generic type in the type declaration, and leave it off on the object constructor
         */
        Set<String> myNames = new HashSet<>();
        myNames.add("Billy");
        myNames.add("Sally");
        myNames.add("Slagathor");
        myNames.add("Teddy");
        myNames.add("Addy");
        // we do not know what order the names will be in till we run the code
        System.out.println(myNames);
        myNames.add("Billy");
        myNames.add("Sally");
        myNames.add("Slagathor");
        myNames.add("Teddy");
        myNames.add("Addy");
        // despite adding a second entry for each name we will still only see one entry of each
        System.out.println(myNames);
        // if you want to access a specific element you must iterate through the collection to find it: no index access
        for(String name : myNames){
            if(name.equals("Slagathor")){
                System.out.println("How did you get in here Slagathor?");
            }
        }

    }

    static void showcaseQueues(){
        /*
            A good implementation choice is the ArrayDeque. It is backed by an array and provides helper methods for
            facilitating your FIFO and LIFO operations
         */

        Deque<String> lineToTheClub = new ArrayDeque<>();
        lineToTheClub.add("Billy");
        lineToTheClub.add("Sally");
        lineToTheClub.add("Slagathor");
        System.out.println(lineToTheClub);
        /*
            Deques provide the means to pull the first and the last element of the collection out of the collection.
            - peek methods are used to check what the value is
            - poll methods are used to get and remove the value from its position
            - offer methods are used to insert values at the start or end of the collection
         */
        // this just checks what the value is without removing it
        System.out.println(lineToTheClub.peekFirst());
        System.out.println(lineToTheClub);
        System.out.println(lineToTheClub.pollFirst());
        System.out.println(lineToTheClub);
        lineToTheClub.offerLast("Teddy");
        System.out.println(lineToTheClub);

    }

    static void showcaseMaps(){
        Map<Integer, String> myNames = new HashMap<>();
        // use the put method to set a key-value pair. The key must be unique. If you reuse a key you will override
        // the previous value
        myNames.put(0,"Billy");
        myNames.put(1,"Sally");
        myNames.put(2,"Slagathor");
        System.out.println(myNames.get(1));
        // here we override the Sally value with Teddy
        myNames.put(1,"Teddy");
        System.out.println(myNames.get(1));
        // you can extract the keys in a Set
        var myKeys = myNames.keySet();
        System.out.println(myKeys);
        // and the values in a custom Collection. Note some operations on the data in the collection will be reflected
        // in the map if you access the values via the map
        var myValues = myNames.values();
        System.out.println(myValues);

    }

    static void wrapperClasses(){
        /*
            All Java primitive data (ints, boolean, char, etc.) have class versions as well. These class versions of the
            primitives have helper methods for working with the primitive data, but they are also used when you must
            provide class data for operations, such as setting the type of data stored in a collection when declaring
            your variables. In these situations Java will perform "autoboxing" for us: this is the process of converting
            a primitive value into an object, or converting the object form back into its primitive state. This is a
            convenience Java performs for us.
         */
        // Our List stores Intgers, this is the object version of int
        List<Integer> myNums = new ArrayList<>();
        // note I am passing a primitive 1 value, but it works, because of java autoboxing. It wraps the primitive
        // as an Object under the hood and provides it to the list
        myNums.add(1);
        // here when we access the value Java converts the value from its Object form back into its primitive state
        System.out.println(myNums.get(0));
        // you CAN make object versions of your primitives, but you will hardly ever actually need to do so because
        // Java handles the autoboxing and unwrapping for us
        Integer myInt = Integer.valueOf(2);
    }

}
