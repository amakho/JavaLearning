package Zadania.semestr2.OperacjeIOiWyjatki;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zadanie4 {
    static void main() {
        pakujDoZIP("date.txt","dane.txt");
    }
    private static void pakujDoZIP(String... sciezkiDoPlikow){
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("archiv.zip"))){
            for (String sciezka : sciezkiDoPlikow){
                File plik = new File(sciezka);
                FileInputStream fileInputStream = new FileInputStream(plik);

                zipOutputStream.putNextEntry(new ZipEntry(plik.getName()));
                byte[] buf = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileInputStream.read(buf)) > 0){
                    zipOutputStream.write(buf, 0, bytesRead);
                }
                zipOutputStream.closeEntry();
                fileInputStream.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
