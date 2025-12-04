package Zadania.semestr2.ProgramowanieObiektowe;
import java.time.LocalDate;
import java.time.Period;
    class Person {
        private LocalDate dateOfBirth;
        private double weight;
        private double hight;

        public Person(LocalDate dateOfBirth, double weight, double hight) {
            this.dateOfBirth = dateOfBirth;
            this.weight = weight;
            this.hight = hight;
        }

        public int getAge() {
            return Period.between(dateOfBirth, LocalDate.now()).getYears();
        }

        public double getBMI() {
            return weight / (hight * hight);
        }
    }
public class Zadanie8 {
    public static void main(String[] args) {
        LocalDate twentyYearsAgo = LocalDate.now().minusYears(22);
        Person anton = new Person(twentyYearsAgo, 74.0, 1.86);
        System.out.println("Anton's age: " + anton.getAge() + " years");
        System.out.printf("Anton's BMI: %.2f\n", anton.getBMI());
    }
}
