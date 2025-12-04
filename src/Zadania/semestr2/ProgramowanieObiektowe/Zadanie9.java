package Zadania.semestr2.ProgramowanieObiektowe;

public class Zadanie9 {
    static void main() {
        Ksiazka k1 = new Ksiazka("Harry Potter","Rowling",1999);
        Ksiazka k2 = new Ksiazka("Hary Potter", " Rowling",1999);
        Ksiazka k3 = new Ksiazka("Harry Potter","Rowling",1999);

        System.out.println("k1 is tha same to k2? "+ k1.isSame(k2));
        System.out.println("k2 is the same to k3? "+ k2.isSame(k3));
        System.out.println("k1 is the same to k3? "+ k1.isSame(k3));
    }
}
class Ksiazka{
    private String title;
    private String author;
    private int yearOfPrint;

    public Ksiazka(String title, String author, int yearOfPrint){
        this.title = title;
        this.author = author;
        this.yearOfPrint = yearOfPrint;
    }

    public boolean isSame(Ksiazka innaKsiazka){
        if (innaKsiazka == null){
            return false;
        }
        if (this.title.equals(innaKsiazka.title)&&
        this.author.equals(innaKsiazka.author)&&
        this.yearOfPrint == innaKsiazka.yearOfPrint){
            return true;
        } else {
            return false;
        }
    }
}

