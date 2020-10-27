package com.epam.training.di;

import java.util.Optional;

public interface DiContext {

	public void addBean(String beanName, Object bean);

	public <T> Optional<T> getBean(String beanName, Class<T> clazz);

	public <T> Optional<T> getBean(Class<T> clazz);

}
