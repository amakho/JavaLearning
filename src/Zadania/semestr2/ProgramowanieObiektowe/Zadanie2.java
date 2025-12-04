package Zadania.semestr2.ProgramowanieObiektowe;

public class Zadanie2 {
    static void main() {
        /*Atrybuty (pola) i metody to kluczowe elementy budujące klasę i definiujące obiekt
        w programowaniu obiektowym (OOP).*/
        class cat{
            String name;
            int hight;
            int weight;

            public cat(String name, int hight, int weight){
                this.name = name;
                this.hight = hight;
                this.weight = weight;
            }

            public void makeSound(){
                System.out.println("meow meow meow");
            }
            public void infoAboutCat(){
                System.out.println("Info about Cat");
                System.out.println("Name is "+ name);
                System.out.println("Hight is "+ hight+" cm");
                System.out.println("Weight is "+weight+" kg");
            }
        }
        cat myCat = new cat("Bars", 10,6);
        myCat.makeSound();
        myCat.infoAboutCat();
    }
}
