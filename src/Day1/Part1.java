package Day1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {
    public static void main(String[] args) throws IOException {
        FileReader input = null;
        int ch, sum = 0, num;

        try
        {
            input = new FileReader("/Users/nferrari/Programacao/AdventOfCode/src/Day1/Input.txt");
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }

        while ((ch = input.read()) != -1) {
            int first = 0;
            int last = 0;
            boolean firstFound = false;
            while (ch != '\n' && ch != -1) {
                if(ch >= 48 && ch <= 57){
                    if(!firstFound){
                        first = ch;
                        last = ch;
                        firstFound = true;
                    }else{
                        last = ch;
                    }
                }
                ch = input.read();

            }
            num = (first - 48) * 10 + last - 48;
            System.out.println(num);
            sum+=num;
        }
        System.out.println("The sum is " + sum);

        // close the file
        input.close();
    }
}
