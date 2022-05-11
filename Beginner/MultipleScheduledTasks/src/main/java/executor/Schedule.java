package executor;

import lombok.Data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Data
public class Schedule implements Runnable{
    private static Logger logger = LogManager.getLogger(Schedule.class);
    int time;
    String message;

    Schedule(int time, String message) {
        this.time = time;
        this.message = message;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(message);
            try {
                Thread.sleep(time * 1000);
            } catch (InterruptedException e) {
                logger.error(e);
            }
        }
    }
}
