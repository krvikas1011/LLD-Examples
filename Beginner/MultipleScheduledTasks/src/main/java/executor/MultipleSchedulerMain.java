package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultipleSchedulerMain {

    public List<Schedule> getSchedulerTasks() {
        List<Schedule> schedulers = new ArrayList<>();
        System.out.println("How many tasks do you want to schedule?");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0; i < num; i++) {
            Schedule scheduler = new Schedule();
            System.out.println("Enter your message:");
            String message = sc.next();
            System.out.println("Enter the time interval:");
            int interval = sc.nextInt();
            scheduler.setMessage(message);
            scheduler.setTime(interval);
            schedulers.add(scheduler);
        }
        return schedulers;
    }

    public static void main(String[] args) {
        MultipleSchedulerMain multipleSchedulerMain = new MultipleSchedulerMain();
        List<Schedule> schedulers = multipleSchedulerMain.getSchedulerTasks();
        Executor executor = new Executor();
        executor.execute(schedulers);
    }
}
