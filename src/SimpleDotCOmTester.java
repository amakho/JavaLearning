public class SimpleDotCOmTester{
    public  static void main(String[] args){
        SimpleDotCom dot = new SimpleDotCom();
        int[] location = {2,3,4};
        dot.setLocationCells(location);
        String userGeess = "2";
        String result = dot.checkYourself(userGeess);
    }
}
