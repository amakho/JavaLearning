package Zadania.semestr2;

import java.util.Random;

public class Zadania2 {
    public static void main(String[] args) {
        int[][][][][] numb;
        numb = new int[1][1][1][1][1];
        Random random = new Random();
        int sum = 0;
        for (int a = 0; a < numb.length; a++){
            for (int b = 0; b < numb.length; b++){
                for (int c = 0; c < numb.length; c++){
                    for (int d = 0; d < numb.length; d++){
                        for (int e = 0; e < numb.length; e++){
                            numb[a][b][c][d][e] = random.nextInt(100);
                            sum += numb[a][b][c][d][e];
                        }
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
