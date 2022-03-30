import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleScheduler {

    private static Logger logger = LogManager.getLogger(SimpleScheduler.class);

    private void scheduleTask(String message, int interval) {
        while(true) {
            System.out.println(message);
            try {
                Thread.sleep(interval * 1000L);
            } catch (InterruptedException e) {
                logger.error("The thread was interrupted ", e);
                System.exit(-1);
            }
        }
    }

    public static void main(String[] args) {
        String message = args[0];
        int interval = 0;
        try {
            interval = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            logger.error("The input given for interval is not integer ", e);
            System.exit(-1);
        }
        new SimpleScheduler().scheduleTask(message, interval);
    }
}