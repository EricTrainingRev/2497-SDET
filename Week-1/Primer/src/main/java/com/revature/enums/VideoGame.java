package com.revature.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VideoGame {

    public static void main(String[] args) {
        Map<String, Direction> userInputs = new HashMap<>();
        userInputs.put("w", Direction.UP);
        userInputs.put("a", Direction.LEFT);
        userInputs.put("s", Direction.DOWN);
        userInputs.put("d", Direction.RIGHT);
        userInputs.put("q", Direction.QUIT);

        boolean keepPlaying = true;
        Scanner scanner = new Scanner(System.in);
        while(keepPlaying){
            System.out.println("Enter your action");
            String userAction = scanner.nextLine();
            Direction direction = userInputs.getOrDefault(userAction, Direction.QUIT);
            switch (direction){
                case Direction.UP:
                    System.out.println("User moves up");
                    break;
                case Direction.DOWN:
                    System.out.println("User moves down");
                    break;
                case Direction.LEFT:
                    System.out.println("User moves left");
                    break;
                case Direction.RIGHT:
                    System.out.println("User moves right");
                    break;
                case Direction.QUIT:
                    System.out.println("Goodbye! Thanks for playing!");
                    keepPlaying = false;
            }
        }
        scanner.close();
    }

}
