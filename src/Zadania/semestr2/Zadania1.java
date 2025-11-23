package Zadania.semestr2;

public class Zadania1 {
    public static void main(String[] args) {
        double[] num = {1.5,2.4,3.3,4.2,5.1,6.9,7.8,8.7,9.6,10.2};
        System.out.println("Od konca:");
        for (int i = num.length - 1; i >= 0; i--){
            System.out.println(num[i]);
        }
        for (int j = 0; j <= num.length; j+=3){
            System.out.println(num[j]);
        }
    }
}
