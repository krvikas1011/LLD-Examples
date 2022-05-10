package executor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

    public void execute(List<Time> tasks) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(Time task : tasks) {
            executorService.submit(task);
        }
    }


}
