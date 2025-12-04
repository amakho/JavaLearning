package Zadania.semestr2.OperacjeIOiWyjatki;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Zadanie7 {
    static void main() {
        int szerokosc = 800;
        int wysokosc = 800;
        BufferedImage obraz = new BufferedImage(szerokosc,wysokosc,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = obraz.createGraphics();
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(0,0,szerokosc,wysokosc);

        g2d.setColor(Color.BLUE);
        g2d.fillOval(250,250,300,300);

        g2d.setColor(Color.MAGENTA);
        g2d.drawLine(300,300,500,500);

        String tekst = "Anton Makhovskyi, 179901";
        Font font = new Font("Arial",Font.BOLD,40);
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);
        int tekstSzerokosc = g2d.getFontMetrics().stringWidth(tekst);
        int tekstWysokosc = g2d.getFontMetrics().getHeight();
        int x = szerokosc - tekstSzerokosc - 160;
        int y = wysokosc - tekstWysokosc - 60;

        g2d.drawString(tekst,x,y);

        try {
            File fileImage = new File("Image.png");
            ImageIO.write(obraz,"png",fileImage);
            System.out.println("Image is created");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
