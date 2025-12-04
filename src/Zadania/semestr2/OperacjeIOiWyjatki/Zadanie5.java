package Zadania.semestr2.OperacjeIOiWyjatki;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Zadanie5 {
    private static final String PLIK_ZRODLOWY = "archiv.zip";
    private static final String KATALOG_DOCELOWY = "unpucked/";
    static void main() {
        unpuckedZIP(PLIK_ZRODLOWY, KATALOG_DOCELOWY);
    }
    private static void unpuckedZIP(String streamArchiv, String catalogUnpucked){
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(streamArchiv))){
            byte[] buf = new byte[1024];

            ZipEntry entry = zipInputStream.getNextEntry();
            while (entry != null){
                String fileName = entry.getName();
                File newFile = new File(catalogUnpucked + fileName);
                new File(newFile.getParent()).mkdir();

                FileOutputStream fileOutputStream = new FileOutputStream(newFile);
                int bytesRead;
                while ((bytesRead = zipInputStream.read(buf)) > 0){
                    fileOutputStream.write(buf,0,bytesRead);
                }
                fileOutputStream.close();
                zipInputStream.closeEntry();
                entry = zipInputStream.getNextEntry();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
