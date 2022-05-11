package executor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

    public void execute(List<TimePrinter> tasks) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(TimePrinter task : tasks) {
            executorService.submit(task);
        }
        executorService.shutdown();
    }


}
