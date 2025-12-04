package Zadania.semestr2.ProjectowanieKlas;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


interface Figura {
    double obliczPole();
    double obliczObwod();
}

// 2. Klasy figur
class Trojkat implements Figura {
    private double a, b, c;

    public Trojkat(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double obliczPole() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double obliczObwod() {
        return a + b + c;
    }
}

class Prostokat implements Figura {
    private double a, b;

    public Prostokat(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double obliczPole() {
        return a * b;
    }

    @Override
    public double obliczObwod() {
        return 2 * a + 2 * b;
    }
}

class Kwadrat implements Figura {
    private double a;

    public Kwadrat(double a) {
        this.a = a;
    }

    @Override
    public double obliczPole() {
        return a * a;
    }

    @Override
    public double obliczObwod() {
        return 4 * a;
    }
}

class Kolo implements Figura {
    private double r;

    public Kolo(double r) {
        this.r = r;
    }

    @Override
    public double obliczPole() {
        return Math.PI * r * r;
    }

    @Override
    public double obliczObwod() {
        return 2 * Math.PI * r;
    }
}

// 3. Fabryka (Factory)
class FiguraFactory {
    public static Figura utworzFigure(String figura, double... parametry) {//Polimorfizm
        switch (figura) {
            case "Trojkat":
                if (parametry.length == 3) {
                    return new Trojkat(parametry[0], parametry[1], parametry[2]);
                }
                break;
            case "Prostokat":
                if (parametry.length == 2) {
                    return new Prostokat(parametry[0], parametry[1]);
                }
                break;
            case "Kwadrat":
                if (parametry.length == 1) {
                    return new Kwadrat(parametry[0]);
                }
                break;
            case "Kolo":
                if (parametry.length == 1) {
                    return new Kolo(parametry[0]);
                }
                break;
        }
        return null;
    }
}

public class Zadanie3 {
     static void main() {
        try {
            File plik = new File("date.txt");
            Scanner skaner = new Scanner(plik);

            while (skaner.hasNext()) {
                if (skaner.hasNext()) {
                    String typ = skaner.next();
                    List<Double> parametryList = new ArrayList<>();

                    // Proste wczytywanie parametrów dla danej linii
                    // Zakładamy, że po nazwie są liczby, aż do końca linii
                    String linia = skaner.nextLine();
                    Scanner skanerLinii = new Scanner(linia);
                    while(skanerLinii.hasNextDouble()) {
                        parametryList.add(skanerLinii.nextDouble());
                    }

                    // Konwersja listy na tablicę double[]
                    //double[] params = parametryList.stream().mapToDouble(d -> d).toArray();
                    double[] params = Arrays.stream(linia.split(" ")).filter(s -> !s.isEmpty()).mapToDouble(Double::parseDouble).toArray();

                    // Użycie fabryki
                    Figura figura = FiguraFactory.utworzFigure(typ, params);

                    if (figura != null) {
                        System.out.println("Figura: " + typ);
                        System.out.printf("Pole: %.2f\n", figura.obliczPole());//Polimorfizm
                        System.out.printf("Obwód: %.2f\n", figura.obliczObwod());
                        System.out.println("-----------------");
                    } else {
                        System.out.println("Nie udało się utworzyć figury: " + typ);
                    }
                }
            }
            skaner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku dane.txt!");
        }
    }
}
