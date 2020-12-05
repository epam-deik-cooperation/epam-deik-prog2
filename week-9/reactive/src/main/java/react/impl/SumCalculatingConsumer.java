package react.impl;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import react.Producer;

public class SumCalculatingConsumer extends AbstractConsumer<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SumCalculatingConsumer.class);

    private AtomicLong sum = new AtomicLong(0);

    public SumCalculatingConsumer(Producer<? extends Integer> producer) {
        super(producer);
    }

    @Override
    protected void handleNext(Integer message) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        var value = sum.addAndGet(message);
        LOGGER.info("Sum value was updated with {}, current value is {}", message, value);
    }
}
