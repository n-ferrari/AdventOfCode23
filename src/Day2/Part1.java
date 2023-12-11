package Day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Part1 {
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

        int red = 12;
        int green = 13;
        int blue = 14;
        int sum = 0;

        for (String l : list) {
            boolean validGame = true;
            String[] begginingString = l.split(": ");
            String[] string2 = begginingString[0].split(" ");
            //System.out.println(begginingString[1]);
            int numberGame = Integer.parseInt(string2[1]);
            l = begginingString[1];
            String[] sets = l.split("; ");
            for(String set : sets){
                String[] colors = set.split(", ");
                for(String color : colors){
                    String[] numberColor = color.split(" ");
                    System.out.println(numberColor[0]+" "+numberColor[1]);
                    if(Objects.equals(numberColor[1], "green")){
                        if(Integer.parseInt(numberColor[0]) > green){
                            validGame = false;
                        }
                    }
                    if(Objects.equals(numberColor[1], "blue")){
                        if(Integer.parseInt(numberColor[0]) > blue){
                            validGame = false;
                        }
                    }
                    if(Objects.equals(numberColor[1], "red")){
                        if(Integer.parseInt(numberColor[0]) > red){
                            validGame = false;
                        }
                    }
                }
            }
            if(validGame){
                sum+=numberGame;
            }
        }
        System.out.println(sum);


    }
}
