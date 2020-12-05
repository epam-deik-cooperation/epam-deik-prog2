package react.impl;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import react.Consumer;
import react.Producer;
import react.Subscription;

public abstract class AbstractConsumer<T> implements Consumer<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractConsumer.class);

    private Subscription subscription = null;
    private ExecutorService threadPool = Executors.newSingleThreadExecutor();

    public AbstractConsumer(Producer<? extends  T> producer) {
        producer.subscribe(this, threadPool);
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        LOGGER.info("Received subscription, cleaning up old subscription and requesting messages...");
        Optional.ofNullable(this.subscription).ifPresent(Subscription::cancel);
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(T message) {
        LOGGER.info("Received message: {}", message);
        handleNext(message);
        subscription.request(1);
    }

    @Override
    public void onComplete() {
        LOGGER.info("Received completed signal, cleaning up subscription.");
        threadPool.shutdown();
    }

    abstract protected void handleNext(T message);
}
