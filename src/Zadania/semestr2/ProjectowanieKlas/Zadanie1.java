package Zadania.semestr2.ProjectowanieKlas;

public class Zadanie1 {
    static void main() {
        Car mclaren = new Car();
        Bicycle rower = new Bicycle();
        mclaren.start();
        rower.start();
    }
}
abstract class Vehicle{
    private String name;
    public Vehicle(){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public abstract void start();
}
class Car extends Vehicle{
    @Override
    public void start() {
        System.out.println("Dyr,dyr,dyr,....bruuuuum");
    }
}
class Bicycle extends Vehicle{
    @Override
    public void start() {
        System.out.println("..........");
    }
}
