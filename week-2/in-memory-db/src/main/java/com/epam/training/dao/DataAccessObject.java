package com.epam.training.dao;

public interface DataAccessObject<T, I> {

	T get(I id);

	T save(T object);

	T update(T object);

	T delete(I id);

}
