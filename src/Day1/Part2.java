package Day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = null;

        String[] numberString = {"one","two","three","four","five","six","seven","eight","nine"};
        ArrayList<String> list=  new ArrayList<>();
        int sum = 0;
        int num = 0;

        try
        {
            input = new BufferedReader(new FileReader("/Users/nferrari/Programacao/AdventOfCode/src/Day1/input.txt"));
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }

        String line = input.readLine();


        //create an array list for all the strings
        while (line != null) {
            list.add(line);
            // read next line
            line = input.readLine();
        }

        changeNumbers(list, numberString);
        changeNumbers(list, numberString);
        changeNumbers(list, numberString);


        //sum the first and the last one
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            int first = 0;
            int last = 0;
            boolean firstFound = false;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) >= 48 && word.charAt(j) <= 57) {
                    if (!firstFound) {
                        first = word.charAt(j);
                        last = word.charAt(j);
                        firstFound = true;
                    } else {
                        last = word.charAt(j);
                    }
                }
            }
            num = (first - 48) * 10 + last - 48;
            System.out.println(num);
            sum += num;
        }

        System.out.println(sum);


        // close the file
        input.close();
    }

    public static void changeNumbers(ArrayList<String> list, String[] numberString){
        //replaces the numbers in String format by integer at the first position of each word
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> indexList = new ArrayList<>(); //numero do index para trocar
            ArrayList<Integer> integerList = new ArrayList<>(); //numeros para trocar
            String word = list.get(i);
            int change = 3;
            while(change > 0){
                for (int j = 0; j < numberString.length; j++) {
                    int index = word.indexOf(numberString[j]);
                    if (index != -1) {
                        indexList.add(index);
                        integerList.add(j + 1);
                        //System.out.println("indexlist: " + index + " integerlist" + (j + 1));
                    }
                }
                change--;
            }
            for (int j = 0; j < numberString.length; j++) {
                int index = word.indexOf(numberString[j]);
                if (index != -1) {
                    indexList.add(index);
                    integerList.add(j + 1);
                    //System.out.println("indexlist: " + index + " integerlist" + (j + 1));
                }
            }
            //substituir numeros por ordem de index
            int minor = 0;
            while(!indexList.isEmpty()){
                minor = 0;
                int indexMinor = indexList.get(0);
                for (int k = 0; k < indexList.size(); k++) {
                    if(indexList.get(k) < indexMinor){
                        indexMinor = indexList.get(k);
                        minor = k;
                    }
                }
                System.out.println(indexMinor);

                word = word.substring(0, indexMinor) + integerList.get(minor) + word.substring(indexMinor + 1);
                System.out.println(word);
                indexList.remove(minor);
                integerList.remove(minor);
            }

            list.set(i, word);
        }
    }
}
