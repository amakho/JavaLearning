package Zadania.semestr2.OperacjeIOiWyjatki;
import java.io.IOException;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Zadanie3 {
    static void main() {
        try {
            Path sciezka = Paths.get("dane.txt");
            List<String> linies = Files.readAllLines(sciezka);
            linies.forEach(System.out::println);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
