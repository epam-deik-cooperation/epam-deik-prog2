package com.epam.training.di.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.epam.training.di.DiContext;

public class DiContextImpl implements DiContext {

	private Map<String, Object> context = new HashMap<>();
	private Map<Class<?>, List<Object>> contextMappedByType = new HashMap<>();
	
	public void addBean(String beanName, Object bean) {
		if (context.containsKey(beanName)) {
			throw new IllegalArgumentException("Bean has been already created: " + beanName);
		}
		context.put(beanName, bean);
		if (contextMappedByType.containsKey(bean.getClass())) {
			contextMappedByType.get(bean.getClass()).add(bean);
		} else {
			List<Object> objectList = new LinkedList<>();
			objectList.add(bean);
			contextMappedByType.put(bean.getClass(), objectList);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> Optional<T> getBean(String beanName, Class<T> clazz) {
		Optional<T> ret = null;
		if (context.containsKey(beanName)) {
			ret = Optional.of((T) context.get(beanName));
		} else {
			ret = Optional.empty();
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Optional<T> getBean(Class<T> clazz) {
		Optional<T> ret = null;
		List<Object> objestList = contextMappedByType.get(clazz);
		if (objestList == null) {
			ret = Optional.empty();
		} else if (objestList.size() != 1) {
			throw new IllegalArgumentException("There are multiple bean available for type: " + clazz);
		} else {
			ret = Optional.of((T) objestList.get(0));
		}		
		return ret;
	}
	
}
