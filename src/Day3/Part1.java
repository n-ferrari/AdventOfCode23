package Day3;

import java.io.*;
import java.util.ArrayList;

public class Part1 {
    public static void main(String[] args) throws IOException {
        FileReader input = null;
        ArrayList<Integer> lineUp =  new ArrayList<>();
        ArrayList<Integer> lineMiddle =  new ArrayList<>();
        ArrayList<Integer> lineDown =  new ArrayList<>();

        //read file
        try
        {
            input = new FileReader("/Users/nferrari/Programacao/AdventOfCode/src/Day3/samplenath.txt");
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }
        //int ch = input.read();

        //read three initial lines
        readLine(lineUp, input);
        readLine(lineMiddle, input);
        readLine(lineDown, input);

        boolean isNum = false;
        boolean isAdjacent = false;
        int number = 0;
        int sum = 0;
        ArrayList<Integer> num = new ArrayList<>(); //array with integers of full number
        ArrayList<Integer> numPositions = new ArrayList<>(); //array with number positions


        //tratar primeira linha
        for(int i = 0; i < lineMiddle.size(); i++){
            int value = lineMiddle.get(i);
            if(value >= 48 && value <= 57){
                isNum = true;
                num.add(value);
                numPositions.add(i);
                //System.out.println(value - 48);
            } else if (isNum) {
                //check if the num is adjacent of a symbol
                //tratar bordas
                int k = 0;
                for (int x = (numPositions.get(0) - 1); x <= (numPositions.size() + 1); x++){
                    if(lineUp.get(x) != '.' && !(lineUp.get(x) >= 48 && lineUp.get(x) <= 57)){
                        isAdjacent = true;
                        System.out.println((num.get(k) -48) + " is adjacente to a symbol line up");
                        break;
                    }
                    if(lineDown.get(x) != '.' && !(lineDown.get(x) >= 48 && lineDown.get(x) <= 57)){
                        isAdjacent = true;
                        System.out.println((num.get(k) -48) + " is adjacente to a symbol line down");
                        break;
                    }
                }

                //verify left values of the middle line
                int middleLeft = lineMiddle.get(numPositions.get(0) - 1);
                if(middleLeft != '.' && !(middleLeft >= 48 && middleLeft <= 57)){
                    isAdjacent = true;
                    System.out.println((num.get(k) - 48) + " is adjacente to a symbol line middle left ");
                }

                //System.out.println("size" + numPositions.size());
                //System.out.println("numpositions" + numPositions.get(numPositions.size()-1));
                //verify right values of the middle line
                int middleRight = lineMiddle.get(numPositions.get(numPositions.size() - 1) + 1);
                if(middleRight != '.' && !(middleRight >= 48 && middleRight <= 57)){
                    isAdjacent = true;
                    System.out.println((num.get(k) - 48) + " is adjacente to a symbol line middle right ");
                }
                k++;
                int decimal = 1;
                if(isAdjacent){
                    for (int j = num.size(); j > 0; j--) {
                        number += (num.get(j - 1) - 48) * decimal;
                        System.out.println("numero para somar"+number);
                        decimal *= 10;
                        //System.out.println("adjacent");
                    }
                    sum += number;
                    //System.out.println(sum);
                }
                number = 0;
                num.clear();
                numPositions.clear();
                isNum = false;
                isAdjacent = false;
            }
        }

        System.out.println("The sum is " + sum);

        //while ((ch = input.read()) != -1) {
        //}
    }

    public static void readLine(ArrayList<Integer> line, FileReader input) throws IOException {
        int ch = input.read();
        while (ch != '\n'){
            line.add(ch);
            ch = input.read();
        }
    }
}
