package com.ik0v;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        int loc = 64;
        while(true) {
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            String dir = locations.get(loc).containsExit(direction);
            if(exits.containsKey(direction)) {
                loc = exits.get(direction);
            }
            else if(exits.containsKey(dir)) {
                loc = exits.get(dir);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }

    }
}
