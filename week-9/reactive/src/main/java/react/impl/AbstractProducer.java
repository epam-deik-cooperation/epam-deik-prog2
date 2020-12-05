package react.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import react.Consumer;
import react.Producer;
import react.Subscription;

public abstract class AbstractProducer<T> implements Producer<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractProducer.class);

    private final List<BufferedSubscriptionImpl<T>> subscriptions = Collections.synchronizedList(new LinkedList<>());
    private final long bufferSize;

    public AbstractProducer(long bufferSize) {
        this.bufferSize = bufferSize;
    }

    @Override
    public synchronized void subscribe(Consumer<? super T> consumer, ExecutorService executorService) {
        LOGGER.info("Received subscribe signal, creating subscription...");
        BufferedSubscriptionImpl<T> subscription = new BufferedSubscriptionImpl<>(bufferSize, consumer, executorService);
        subscriptions.add(subscription);
        consumer.onSubscribe(subscription);
    }

    public synchronized void onCancel(Subscription subscription) {
        LOGGER.info("Received cancel signal, removing subscription.");
        subscriptions.remove(subscription);
    }

    public void block() {
        LOGGER.info("Blocking to request messages.");
        while (!completed()) {
            T message = next();
            LOGGER.info("Publishing message {}.", message);
            subscriptions.forEach(subscription -> subscription.offer(message));
        }
        subscriptions.forEach(BufferedSubscriptionImpl::completed);
        LOGGER.info("Completed stream.");
    }

    abstract protected T next();

    abstract protected boolean completed();
}
