package Zadania.semestr2.OperacjeIOiWyjatki;

import java.io.*;

public class Zadanie2 {
    static void main() {
        //BufferedReader reader = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("date.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("dane.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);

                writer.write(line);
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}