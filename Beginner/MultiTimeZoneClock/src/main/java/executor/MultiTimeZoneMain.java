package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiTimeZoneMain {
    public List<Time> getSchedulerTasks() {
        List<Time> tasks = new ArrayList<>();
        System.out.println("How many time zones do you want to print?");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0; i < num; i++) {
            System.out.println("Enter your timezone:");
            String timezone = sc.next();
            System.out.println("Enter the time interval:");
            int interval = sc.nextInt();
            Time time = new Time(interval, timezone);
            tasks.add(time);
        }
        return tasks;
    }

    public static void main(String[] args) {
        MultiTimeZoneMain multipleSchedulerMain = new MultiTimeZoneMain();
        List<Time> tasks = multipleSchedulerMain.getSchedulerTasks();
        Executor executor = new Executor();
        executor.execute(tasks);
    }
}
