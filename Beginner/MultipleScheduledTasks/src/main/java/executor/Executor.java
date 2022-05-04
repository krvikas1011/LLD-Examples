package executor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

    public void execute(List<Schedule> schedulers) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(Schedule scheduler : schedulers) {
            executorService.submit(scheduler);
        }
        executorService.shutdown();
    }

}
