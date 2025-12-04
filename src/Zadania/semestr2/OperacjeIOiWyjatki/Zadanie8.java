package Zadania.semestr2.OperacjeIOiWyjatki;


public class Zadanie8 {
    static class SlowTrackTime extends Exception{
        public SlowTrackTime(String komunikat){
            super(komunikat);
        }
    static void main() {
        double yourTrackTime = 1.26;
        Track myTrack = new Track();
        try {
            myTrack.checkTime(yourTrackTime);
        } catch (SlowTrackTime e){
            System.out.println("Houston, We have a ptoblem");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Your time is "+ yourTrackTime);
        }
    }
    }
    static class Track{
        public void checkTime(double time) throws SlowTrackTime{
            if (time > 1.32) {
                throw new SlowTrackTime("Your time is too slow " + time);
            }if (time > 1.29){
                throw new SlowTrackTime("Your time is " + time + "\n You need set minimum 1.29!");
            }

            System.out.println("Your time is impressed");
        }
    }
}
