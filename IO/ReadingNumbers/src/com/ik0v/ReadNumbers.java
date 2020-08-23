package com.ik0v;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadNumbers {
    private BufferedReader reader;
    public static int counter = 0;

    public ReadNumbers(BufferedReader reader) {
        this.reader = reader;
    }

    public ArrayList<Integer> readWholeNumbers() {
        ArrayList<Integer> wholeNr = new ArrayList<>();
        try {
            String nextLine = reader.readLine();
            if(nextLine == null) {
                return null;
            } else {
                Scanner scanner = new Scanner(nextLine);
                counter++;
                while (scanner.hasNext()) {
                    try {
                        wholeNr.add(scanner.nextInt());
                    } catch (InputMismatchException e) {
                        String error = scanner.next();
                        System.out.println("Error, not an integer: \"" + error + "\" at line: " + counter);
                    }
                }
                scanner.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        return wholeNr;
    }

    public ArrayList<Double> readDecNumbers() {
        ArrayList<Double> decNr = new ArrayList<>();
        try {
            String nextLine = reader.readLine();
            if(nextLine == null) {
                return null;
            } else {
                Scanner scanner = new Scanner(nextLine);
                counter++;
                while (scanner.hasNext()) {
                    try {
                        double nextDbl = scanner.nextDouble();
                        if (nextDbl % 1 != 0) {
                            decNr.add(nextDbl);
                        } else {
                            System.out.println("Error, not a decimal: \"" + (int)nextDbl + "\" at line: " + counter);
                        }
                    } catch (InputMismatchException e) {
                        String error = scanner.next();
                        System.out.println("Error, not a decimal: \"" + error + "\" at line: " + counter);
                    }
                }
                scanner.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        return decNr;
    }

}
