package Zadania.semestr2.ProjectowanieKlas;


public class Zadanie2 {
    static void main() {
        Mcbook apple = new Mcbook();
        for (int i = 0; i < 10; i++) {
            apple.On(1);
            apple.Off(2);
        }
    }
}
interface Laptop{
    void On(int times);
    void Off(int times);
}
class Mcbook implements Laptop{
    public static int countOfStart;
    @Override
    public void On(int times) {
        System.out.println("Mcbook start working!");
        countOfStart++;

    }

    @Override
    public void Off(int times) {
        System.out.println("You finish, its your " + countOfStart +" times");
    }
}