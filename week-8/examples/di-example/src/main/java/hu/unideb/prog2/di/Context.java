package hu.unideb.prog2.di;

public interface Context {

    int someValue =10;

    <T> T getBeanForType(Class<T> type);
}
