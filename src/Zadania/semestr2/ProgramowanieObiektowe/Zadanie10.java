package Zadania.semestr2.ProgramowanieObiektowe;

import java.util.ArrayList;

public class Zadanie10 {
    static void main() {
        ArrayList<Books> booklist = new ArrayList<Books>();
        booklist.add(new Books("Harry Potter -"," Rowling",1999));
        booklist.add(new Books("Lord of the Ring -","Talkin",1980));
        booklist.add(new Books("Head First -"," Bayers ",2002));
        booklist.add(new Books("OOP -"," Sierra",2001));
        booklist.add(new Books("Apple -"," Jobs",2000));
        booklist.add(new Books("Little prince -"," AdE",1987));
        for (Books k : booklist){
            if (k.getYearsOfPrint() > 2000){
                System.out.println(k.getNameOfBook() + k.getBooksauthor());
            }
        }
    }
}
class Books{
    private String nameOfBook;
    private String booksauthor;
    private int yearsOfPrint;
    public Books(String nameOfBook, String booksauthor, int yearsOfPrint){
        this.nameOfBook = nameOfBook;
        this.booksauthor = booksauthor;
        this.yearsOfPrint = yearsOfPrint;
    }
    public int getYearsOfPrint(){
        return yearsOfPrint;
    }
    public String getNameOfBook(){
        return nameOfBook;
    }
    public String getBooksauthor(){
        return booksauthor;
    }
}

