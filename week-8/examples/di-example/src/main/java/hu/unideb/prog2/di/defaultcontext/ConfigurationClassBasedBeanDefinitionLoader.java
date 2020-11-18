package hu.unideb.prog2.di.defaultcontext;

import hu.unideb.prog2.di.annotation.Bean;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigurationClassBasedBeanDefinitionLoader implements BeanDefinitionLoader {

    private final Class<?> configurationClass;

    public ConfigurationClassBasedBeanDefinitionLoader(Class<?> configurationClass) {
        this.configurationClass = configurationClass;
    }

    @Override
    public List<BeanDefinition> loadBeanDefinitions() {
        return Arrays.stream(configurationClass.getDeclaredMethods())
                .filter(this::shouldCreateBeanDefinitionForMethod)
                .map(this::createBeanDefinition)
                .collect(Collectors.toList());
    }

    private boolean shouldCreateBeanDefinitionForMethod(Method method) {
        boolean isAnnotatedWithBean = Arrays.stream(method.getAnnotations())
                .anyMatch(annotation -> Bean.class.equals(annotation.annotationType()));
        return isAnnotatedWithBean && Modifier.isStatic(method.getModifiers());
    }

    private BeanDefinition createBeanDefinition(Method method) {
        return new BeanDefinition(method.getReturnType(), method);
    }
}
