package finalproject;

public class GameThread extends Thread {

    //Game values - Written by Paul
    private GameFrame f;

    private int score = 0;
    private int health = 100;
    private int numright = 0;
    private int numfalse = 0;
    private int milliseconds = 0;

    //Connects Game Frame and Game Thread, used in GameFrame - Written by Paul
    public GameThread(GameFrame form) {
        f = form;
    }
    
    public void resetGameThread() {
        score = 0;
        health = 100;
        numright = 0;
        numfalse = 0;
        milliseconds = 0;
    }

    //Formats milliseconds for the stopwatch label, used in GameFrame - Written by Paul
    public String formatTime() {
        int m = (milliseconds % 360000) / 6000;
        int s = (milliseconds / 100) % 60;
        int ms = milliseconds % 100;
        String mm, ss, mss;
        mm = addZero(m);
        ss = addZero(s);
        mss = addZero(ms);
        return mm + ":" + ss + ":" + mss;
    }

    //Adds leading zeros for formating - Written by Paul, modified by Justin
    private String addZero(int i) {
        String s;
        if (i < 10) {
            s = "0" + i;
        } else {
            s = String.valueOf(i);
        }
        return s;
    }

    //Runs GameThread, used in GameFrame - Written by Paul, modified by Justin
    public void run() {
        resetGameThread();
        //For the 3, 2, 1, Start countdown when openning Game Frame - Writtin by Justin
        for (int i = 3; i > 0; i--) {
            f.updateStartCountdown(String.valueOf(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                return;
            }
        }
        f.updateStartCountdown("Start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            return;
        }
        f.deleteStartCountdown();
        f.startGame();
        //Stopwatch counting up - Written by Paul, modified by Justin
        while (true) {
            f.updateStopwatch(formatTime());
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                resetGameThread();
                return;
            }
            milliseconds++;
        }
    }
}
