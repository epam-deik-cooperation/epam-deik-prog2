package hu.unideb.prog2.di.defaultcontext;

import hu.unideb.prog2.di.Context;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class BeanDefinition {

    private Class<?> beanType;
    private Method factoryMethod;

    public BeanDefinition(Class<?> beanType, Method factoryMethod) {
        this.beanType = beanType;
        this.factoryMethod = factoryMethod;
    }

    public Object createBean(Context context) {
        Class<?>[] parameterTypes = factoryMethod.getParameterTypes();
        Object[] dependencies = Arrays.stream(parameterTypes)
                .map(context::getBeanForType)
                .toArray();
        try {
            return factoryMethod.invoke(null, dependencies);
        } catch (IllegalAccessException|InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public Class<?> getBeanType() {
        return beanType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeanDefinition that = (BeanDefinition) o;
        return Objects.equals(beanType, that.beanType) &&
                Objects.equals(factoryMethod, that.factoryMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beanType, factoryMethod);
    }
}