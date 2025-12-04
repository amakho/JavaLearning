package Zadania.semestr2.ProgramowanieObiektowe;

public class Zadanie1 {
    static void main() {
    /*Klasa jest szablonem (planem) dla obiektów, określającym ich wspólne cechy (pola) i zachowania (metody).
Obiekt to konkretna instancja (egzemplarz) klasy, która posiada rzeczywiste wartości dla tych cech i zajmuje pamięć. */

        class samochod {
            String marka;
            String model;
            int rokProdukcji;

            public void jazda(){
                System.out.println(" Moj samochod marki " + marka + " jedzi");
            }
        }

        samochod mojSamochod = new samochod();
        mojSamochod.marka = "Mclaren";
        mojSamochod.jazda();

    }
}
