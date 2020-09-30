package com.epam.training.dao;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractInMemoryDao<T, I> implements DataAccessObject<T, I> {

	protected Map<I, T> map = new HashMap<>();

	@Override
	public T get(I id) {
		return map.get(id);
	}

	@Override
	public T save(T object) {
		return map.put(getId(object), object);
	}

	@Override
	public T update(T object) {
		return map.put(getId(object), object);
	}

	@Override
	public T delete(I id) {
		return map.remove(id);
	}

	abstract protected I getId(T object);

}
