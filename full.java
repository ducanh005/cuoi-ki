import java.time.LocalTime;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Thread clockThread = new Thread(() -> {
            while (true) {
                LocalTime time = LocalTime.now();
                System.out.printf("Current Time: %02d:%02d:%02d%n", time.getHour(), time.getMinute(), time.getSecond());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread randomThread = new Thread(() -> {
            Random rand = new Random();
            int number = rand.nextInt(100) + 1;
            System.out.println("Random number: " + number);
        });

        clockThread.start();
        randomThread.start();
    }
}
