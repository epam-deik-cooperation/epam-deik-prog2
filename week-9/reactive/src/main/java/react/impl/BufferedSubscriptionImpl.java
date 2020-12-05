package react.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import react.Consumer;
import react.Subscription;

public class BufferedSubscriptionImpl<T> implements Subscription {

    private static final Logger LOGGER = LoggerFactory.getLogger(BufferedSubscriptionImpl.class);

    private AtomicLong demand = new AtomicLong(0);
    private LimitedQueue<T> messageBuffer;
    private ExecutorService consumerExecutorService;
    private Consumer<? super T> consumer;
    private boolean completed = false;

    public BufferedSubscriptionImpl(long bufferSize, Consumer<? super T> consumer, ExecutorService consumerExecutorService) {
        messageBuffer = new LimitedQueue<>(bufferSize);
        this.consumerExecutorService = consumerExecutorService;
        this.consumer = consumer;
    }

    @Override
    public void request(long count) {
        LOGGER.info("Received request for {} message(s).", count);
        demand.addAndGet(count);
        tryDeliver();
    }

    @Override
    public void cancel() {
        LOGGER.info("Received cancel signal.");
        demand.set(0);
    }

    public void offer(T message) {
        LOGGER.info("Received message {} .", message);
        messageBuffer.enqueue(message);
        tryDeliver();
    }

    public void completed() {
        completed = true;
        tryDeliver();
    }

    private synchronized void tryDeliver() {
        LOGGER.info("Trying to deliver messages in queue.");
        if (messageBuffer.size()<=0 && completed) {
            consumer.onComplete();
        }
        if (demand.getAndUpdate(value -> Math.max(0, value - 1)) > 0) {
            messageBuffer.dequeue()
                .ifPresentOrElse(item -> consumerExecutorService.execute(() -> consumer.onNext(item)),
                    () -> demand.getAndIncrement());
        }
    }
}
