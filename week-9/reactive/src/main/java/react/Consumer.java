package react;

public interface Consumer<T> {
    void onSubscribe(Subscription subscription);
    void onNext(T message);
    void onComplete();
}
