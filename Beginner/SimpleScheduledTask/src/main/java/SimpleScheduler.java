import java.util.Scanner;

public class SimpleScheduler {

    private void scheduleTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message:");
        String message = sc.next();
        System.out.println("Enter the interval in seconds:");
        int interval = sc.nextInt();
        while(true) {
            System.out.println(message);
            try {
                Thread.sleep(interval * 1000L);
            } catch (InterruptedException e) {
                System.exit(-1);
            }
        }
    }

    public static void main(String[] args) {
        new SimpleScheduler().scheduleTask();
    }


}
