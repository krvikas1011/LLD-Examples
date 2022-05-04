package executor;

import lombok.Data;

@Data
public class Schedule implements Runnable{
    int time;
    String message;

    @Override
    public void run() {
        while(true) {
            System.out.println(message);
            try {
                Thread.sleep(time * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
