package scheduler;

import model.Schedule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleScheduler {

    private static Logger logger = LogManager.getLogger(SimpleScheduler.class);

    public void scheduleTask(Schedule schedule) {
        while(true) {
            System.out.println(schedule.getMessage());
            try {
                Thread.sleep(schedule.getInterval() * 1000L);
            } catch (InterruptedException e) {
                logger.error("The thread was interrupted ", e);
                System.exit(-1);
            }
        }
    }

    public Schedule getScheduleData(String[] args) {
        Schedule scheduleObject = new Schedule();
        String message = args[0];
        int interval = 0;
        try {
            interval = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            logger.error("The input given for interval is not integer ", e);
            System.exit(-1);
        }
        scheduleObject.setMessage(message);
        scheduleObject.setInterval(interval);
        return scheduleObject;
    }
}