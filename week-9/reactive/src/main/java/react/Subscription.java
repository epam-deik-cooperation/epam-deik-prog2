package react;

public interface Subscription {
    void request(long count);
    void cancel();
}
