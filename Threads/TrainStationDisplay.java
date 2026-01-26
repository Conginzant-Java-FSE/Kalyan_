package ThreadAssignments;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

class DisplayBoard {

    public synchronized void update(String trainName) {
        System.out.println(trainName + " updating display board.");

        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("Display: Train " + trainName + " arrived at " + time);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(trainName + " done updating.\n");
    }
}

class Train extends Thread {
    private String trainName;
    private DisplayBoard board;
    private Random random = new Random();

    Train(String trainName, DisplayBoard board) {
        this.trainName = trainName;
        this.board = board;
    }

    @Override
    public void run() {
        try {
            System.out.println(trainName + " is arriving...");
            Thread.sleep(1000 + random.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        board.update(trainName);
    }
}

public class TrainStationDisplay {
    public static void main(String[] args) {

        DisplayBoard board = new DisplayBoard();

        Train t1 = new Train("Rajdhani Express", board);
        Train t2 = new Train("Shatabdi Express", board);
        Train t3 = new Train("Duronto Express", board);

        t1.start();
        t2.start();
        t3.start();
    }
}
