package react.impl;

import java.util.concurrent.atomic.AtomicInteger;

public class IntSequenceProducer extends AbstractProducer<Integer> {

    AtomicInteger currentNumber = new AtomicInteger(0);

    public IntSequenceProducer(long bufferSize) {
        super(bufferSize);
    }

    @Override
    protected Integer next() {
        return currentNumber.getAndIncrement();
    }

    @Override
    protected boolean completed() {
        return currentNumber.get()>=10;
    }
}
