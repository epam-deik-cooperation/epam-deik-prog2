package react.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import react.Producer;

public class AverageCalculatingConsumer extends AbstractConsumer<Integer>{

    public static final Logger LOGGER = LoggerFactory.getLogger(AverageCalculatingConsumer.class);
    private int count = 0;
    private long sum = 0;

    public AverageCalculatingConsumer(Producer<? extends Integer> producer) {
        super(producer);
    }

    @Override
    protected synchronized void handleNext(Integer message) {
        count += 1;
        sum += message;
        LOGGER.info("Updated average with {}, the current value is {}", message, ((float)sum)/count);
    }
}
