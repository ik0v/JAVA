package com.ik0v;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String fileName = "numbersFile.txt";
        try {
            BufferedReader bfReader = new BufferedReader(new FileReader(fileName));
            ReadNumbers lineReader = new ReadNumbers(bfReader);

            String result = "";

            // Reading decimal numbers, all lines
            ArrayList<Integer> nextLine = lineReader.readWholeNumbers();
            while (nextLine != null) {
                if(!nextLine.isEmpty()) {
                    result += nextLine + "\n";
                }
                nextLine = lineReader.readWholeNumbers();
            }

            // Reading decimal numbers, all lines
//            ArrayList<Double> nextLine = lineReader.readDecNumbers();
//            while (nextLine != null) {
//                if(!nextLine.isEmpty()) {
//                    result += nextLine + "\n";
//                }
//                nextLine = lineReader.readDecNumbers();
//            }

            bfReader.close();
            System.out.println(result + ReadNumbers.counter + " lines read totally. " +
                    "Only lines containing valid digit type are shown here");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("IO-Exception with opening/closing file: " + fileName);
        }

    }
}
