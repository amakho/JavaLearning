package PLWSBMerito;

public class Main08Sample {
    public static void main(String[] args){
        int n = 5;
        for (int i = 0; i < n;i++){
            String row = "";
            for (int j = 0;j <= i; j++) {
                row += "*";
            }
                for (int j = i + 1; j< 5; j++){
                    //row = "*";
                    row += j + 1;
                }
                System.out.println(row);
        }
    }
}
