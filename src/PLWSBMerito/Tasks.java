package PLWSBMerito;

public class Tasks {
    public static void main(String[]args){
        // Task 1
        int x = 10;
        char c = '4';
        long v = 25678;
        double m = 5.3;
        boolean n = true;
        System.out.println(x);
        System.out.println(c);
        System.out.println(v);
        System.out.println(m);
        System.out.println(n);
        // Task 2
        byte p = 94;
        short d = 257;
        int a = p + d;
        System.out.println(a);
        // Task 3
        int nr1 = 5;
        int nr2 = 3;
        int result = nr1 / nr2;
        System.out.println(result);
        // Task 4
        String st1 = "Java ";
        String st2 = "Course";
        String res = st1 + st2;
        System.out.println(res);
        // Task 5
        double d1 = 5.1;
        float d2 = 5.0f;
        boolean r = d1 > d2;
        System.out.println(r);
        // Task 6
        byte num1 = 3;
        byte num2 = 7;
        if (num1 > num2){
            System.out.println("The large number is " + num1);
        } else {
            System.out.println("The large number is " + num2);
        }
        // Task 7
        for(int i = 1; i <= 10;i++){
            System.out.println(i);
        }
        int t = 1;
        while (t <= 10){
            System.out.println(t);
            t++;
        }
        // Task 8
        int numer1 = 3;
        int numer2 = 7;
        int numer3 = 11;
        if (numer1 > numer2 && numer1 > numer3){
            System.out.println("The greatest number is " + numer1);
        } else if (numer2 > numer1 && numer2 > numer3) {
            System.out.println("The greatest number is " + numer2);
        } else if (numer3 > numer1 && numer3 > numer2) {
            System.out.println("The greatest number is " + numer3);
        }
        // Task 9
        for (int j = 0; j < 3; j++){
            System.out.println("Java");
        }
        int b = 0;
        while (b < 3){
            System.out.println("Java");
            b++;
        }
        // Task 10
        int resultFor = 0;
        int resultWhile = 0;
        for (int h = 1; h <= 10; h++){
            resultFor = resultFor + h;
        }
        System.out.println(resultFor);
        int g = 1;
        while (g <= 10){
            resultWhile = resultWhile + g;
            g++;
        }
        System.out.println(resultWhile);
        // Task 11
        int q = 6;
        for (int l = 0; l <= q; l++){
            if (l % 2 == 0){
                System.out.println(l + " even");
            } else {
                System.out.println(l + " odd");
            }
        }
        for(int f = 0; f < 3;f++){
            for(int y = 0; y < 3;y++){
                System.out.println("f = " + f + " y =" + y);
            }
        }
    }
}
