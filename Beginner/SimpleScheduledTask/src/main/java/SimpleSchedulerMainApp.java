import scheduler.SimpleScheduler;
import model.Schedule;

public class SimpleSchedulerMainApp {

    public static void main(String[] args) {
        SimpleScheduler simpleScheduler = new SimpleScheduler();
        Schedule schedule = simpleScheduler.getScheduleData(args);
        simpleScheduler.scheduleTask(schedule);
    }
}
