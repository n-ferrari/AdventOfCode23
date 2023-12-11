package Day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Part2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = null;
        ArrayList<String> list =  new ArrayList<>();

        //read file
        try
        {
            input = new BufferedReader(new FileReader("/Users/nferrari/Programacao/AdventOfCode/src/Day2/input.txt"));
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }

        //create an array list for all the strings
        String line = input.readLine();
        while (line != null) {
            list.add(line);
            // read next line
            line = input.readLine();
        }

        int biggerRed, biggerGreen, biggerBlue;
        int multiplication;
        int sum = 0;


        for (String l : list) {
            biggerGreen = 0;
            biggerRed = 0;
            biggerBlue = 0;
            String[] begginingString = l.split(": ");
            l = begginingString[1];
            String[] sets = l.split("; ");

            for(String set : sets){
                String[] colors = set.split(", ");
                for(String color : colors){
                    String[] numberColor = color.split(" ");

                    if(Objects.equals(numberColor[1], "green")){
                        if(Integer.parseInt(numberColor[0]) > biggerGreen){
                            biggerGreen = Integer.parseInt(numberColor[0]);
                        }
                        }
                    if(Objects.equals(numberColor[1], "red")){
                        if(Integer.parseInt(numberColor[0]) > biggerRed){
                            biggerRed = Integer.parseInt(numberColor[0]);
                        }
                    }
                    if(Objects.equals(numberColor[1], "blue")){
                        if(Integer.parseInt(numberColor[0]) > biggerBlue){
                            biggerBlue = Integer.parseInt(numberColor[0]);
                        }
                    }
                }
            }
            multiplication = biggerRed * biggerGreen * biggerBlue;
            sum+= multiplication;
        }
        System.out.println(sum);
        }

    }

