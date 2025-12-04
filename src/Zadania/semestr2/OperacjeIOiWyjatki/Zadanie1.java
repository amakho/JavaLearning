package Zadania.semestr2.OperacjeIOiWyjatki;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Zadanie1 {
    static void main() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("date.txt"));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e){
            System.out.println("File is not found" + e.getMessage());
        } catch (IOException e){
            System.out.println("Error");
        }
        try {
            if (reader != null){
                reader.close();
            }
        } catch (IOException e){
            System.out.println("Problem with stream "+ e.getMessage());
        }
    }
}
