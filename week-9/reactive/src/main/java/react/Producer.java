package react;

import java.util.concurrent.ExecutorService;

public interface Producer<T> {
    void subscribe(Consumer<? super T> consumer, ExecutorService executorService);
}
