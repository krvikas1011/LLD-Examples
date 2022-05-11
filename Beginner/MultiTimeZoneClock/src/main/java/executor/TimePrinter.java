package executor;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Data
public class TimePrinter implements Runnable{
    private static Logger logger = LogManager.getLogger(TimePrinter.class);

    private String timezone;
    private int interval;

    public TimePrinter(int interval, String timezone) {
        this.interval = interval;
        this.timezone = timezone;
    }

    @Override
    public void run() {
        TimeFinder timeFinder = new TimeFinder();
        while(true) {
            timeFinder.getTimeForTimezone(timezone);
            try {
                Thread.sleep(interval * 1000);
            } catch (InterruptedException e) {
                logger.error(e);
            }
        }
    }
}
