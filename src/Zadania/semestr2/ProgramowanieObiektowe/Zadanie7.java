package Zadania.semestr2.ProgramowanieObiektowe;

import java.time.LocalDate;

public class Zadanie7 {
        class Book{
            private String name;
            private int yearOfPrint;
            public Book(String name, int yearOfPrint){
                this.name = name;
                this.yearOfPrint = yearOfPrint;
            }
            public int getYearOfPrint(){
                return yearOfPrint;
            }
            public String getName(){
                return name;
            }

        }
    public void bookAge(Book book){
        LocalDate todayDay = LocalDate.now();
        int currentYear = todayDay.getYear();
        int yearOfPrint = book.yearOfPrint;
        int bookAge = currentYear - yearOfPrint;
        System.out.println("Book " + book.getName() + "get printed in " + yearOfPrint);
        System.out.println("Book " + book.getName() +" has a " + bookAge + " years");
    }

    public static void main() {
            Zadanie7 demoBook = new Zadanie7();
            Zadanie7.Book myFavoriteBook = demoBook.new Book("Harry Potter", 1999);
            demoBook.bookAge(myFavoriteBook);
    }
}
