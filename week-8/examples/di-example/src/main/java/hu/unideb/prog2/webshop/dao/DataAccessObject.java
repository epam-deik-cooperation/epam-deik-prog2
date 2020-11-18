package hu.unideb.prog2.webshop.dao;

import java.util.List;

public interface DataAccessObject<T> {

	void create(T t);
	
	void remove(Integer id);
	
	List<T> list();
	
}
