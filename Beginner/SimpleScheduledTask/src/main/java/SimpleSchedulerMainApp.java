import scheduler.SimpleScheduler;
import model.ScheduleObject;

public class SimpleSchedulerMainApp {

    public static void main(String[] args) {
        SimpleScheduler simpleScheduler = new SimpleScheduler();
        ScheduleObject scheduleObject = simpleScheduler.getScheduleData(args);
        simpleScheduler.scheduleTask(scheduleObject);
    }
}
