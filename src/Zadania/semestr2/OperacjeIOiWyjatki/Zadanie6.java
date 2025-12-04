package Zadania.semestr2.OperacjeIOiWyjatki;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Zadanie6 {
    static void main() {
        String adresURL = "https://www.google.com";
        String fileName = "saved_page.html";

        savedPageWWW(adresURL,fileName);
    }
    private static void savedPageWWW(String adresURL, String fileName){
        try {
            URL url = new URL(adresURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
                String line;
                while ((line = reader.readLine()) != null){
                    writer.write(line);
                    writer.newLine();
                }
                System.out.println("Strona saved without problem " + fileName);
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (MalformedURLException e){
            System.out.println("Problem with URL adres" + adresURL);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
