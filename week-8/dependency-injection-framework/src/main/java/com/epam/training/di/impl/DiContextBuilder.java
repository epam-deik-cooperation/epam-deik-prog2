package com.epam.training.di.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.epam.training.di.Configuration;
import com.epam.training.di.DiContext;
import com.epam.training.di.annotation.Bean;
import com.epam.training.di.annotation.Qualifier;

public class DiContextBuilder {

	public DiContext build(Configuration contextConfiguration) {
		DiContext context = new DiContextImpl();

		List<BeanDefinition> beanDefinitions = new LinkedList<BeanDefinition>();

		for (Method method : contextConfiguration.getClass().getMethods()) {
			if (isAnnotatedWithBean(method)) {
				List<BeanDefinitionParameter> beanDependencies = new LinkedList<DiContextBuilder.BeanDefinitionParameter>();
				for (Parameter parameter : method.getParameters()) {
					String name = null;
					if (parameter.getAnnotation(Qualifier.class) != null) {
						name = parameter.getAnnotation(Qualifier.class).name();
					}
					beanDependencies.add(new BeanDefinitionParameter<>(name, parameter.getType()));
				}
				beanDefinitions
						.add(new BeanDefinition(method.getName(), method.getReturnType(), method, beanDependencies));
			}
		}

		int beanDefinitionsSize = beanDefinitions.size();
		context.addBean("context", context);

		while (beanDefinitions.size() > 0) {
			List<BeanDefinition> resolvedBeanDefinitions = new LinkedList<>();
			for (BeanDefinition beanDefinition : beanDefinitions) {
				if (isBeanDefinitionResolvable(beanDefinition, context)) {
					context.addBean(beanDefinition.name, createBean(beanDefinition, context, contextConfiguration));
					resolvedBeanDefinitions.add(beanDefinition);
				}
			}
			beanDefinitions.removeAll(resolvedBeanDefinitions);

			if (beanDefinitionsSize == beanDefinitions.size()) {
				throw new IllegalArgumentException("Circular dependency!");
			} else {
				beanDefinitionsSize = beanDefinitions.size();
			}
		}

		return context;
	}

	private Object createBean(BeanDefinition beanDefinition, DiContext context, Object contextConfiguration) {
		List<Object> dependencies = new ArrayList<>(beanDefinition.dependencies.size());

		for (BeanDefinitionParameter parameter : beanDefinition.dependencies) {
			Optional<Object> dependency;
			if (parameter.name != null) {
				dependency = context.getBean(parameter.name, parameter.type);
			} else {
				dependency = context.getBean(parameter.type);
			}
			dependencies.add(dependency.get());
		}

		try {
			return beanDefinition.builderMethod.invoke(contextConfiguration, dependencies.toArray());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private boolean isBeanDefinitionResolvable(BeanDefinition beanDefinition, DiContext context) {
		for (BeanDefinitionParameter parameter : beanDefinition.dependencies) {
			Optional<Object> dependency;
			if (parameter.name != null) {
				dependency = context.getBean(parameter.name, parameter.type);
			} else {
				dependency = context.getBean(parameter.type);
			}
			if (dependency.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	private boolean isAnnotatedWithBean(Method method) {
		for (Annotation annotation : method.getDeclaredAnnotations()) {
			if (annotation.annotationType().equals(Bean.class)) {
				return true;
			}
		}
		return false;
	}

	private class BeanDefinition {
		String name;
		Class type;
		Method builderMethod;
		List<BeanDefinitionParameter> dependencies;

		public BeanDefinition(String name, Class type, Method builderMethod,
				List<BeanDefinitionParameter> dependencies) {
			super();
			this.name = name;
			this.type = type;
			this.builderMethod = builderMethod;
			this.dependencies = dependencies;
		}
	}

	private class BeanDefinitionParameter<T> {
		String name;
		Class<T> type;

		public BeanDefinitionParameter(String name, Class<T> type) {
			super();
			this.name = name;
			this.type = type;
		}
	}

}
