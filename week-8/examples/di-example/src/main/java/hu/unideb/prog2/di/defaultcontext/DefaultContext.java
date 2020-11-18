package hu.unideb.prog2.di.defaultcontext;

import hu.unideb.prog2.di.Context;

import java.util.*;

public class DefaultContext implements Context {

    Map<BeanDefinition, Optional<Object>> beanDefinitionToObjectMap;

    public DefaultContext(BeanDefinitionLoader definitionLoader) {
        beanDefinitionToObjectMap = new HashMap<>();
        definitionLoader.loadBeanDefinitions().forEach(def -> beanDefinitionToObjectMap.put(def, Optional.empty()));
    }

    @Override
    public <T> T getBeanForType(Class<T> expectedBeanType) {
        Map.Entry<BeanDefinition, Optional<Object>> beanDefinitionEntry = beanDefinitionToObjectMap.entrySet().stream()
                .filter(definition -> definition.getKey().getBeanType().equals(expectedBeanType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No bean found for type " + expectedBeanType.getCanonicalName()));
        if (beanDefinitionEntry.getValue().isEmpty()) {
            beanDefinitionEntry.setValue(Optional.of(beanDefinitionEntry.getKey().createBean(this)));
        }
        return (T) beanDefinitionEntry.getValue().get();
    }
}
