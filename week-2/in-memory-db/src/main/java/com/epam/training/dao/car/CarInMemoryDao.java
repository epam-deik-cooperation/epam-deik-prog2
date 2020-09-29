package com.epam.training.dao.car;

import com.epam.training.dao.AbstractInMemoryDao;

public class CarInMemoryDao extends AbstractInMemoryDao<Car, Long> {

	@Override
	protected Long getId(Car car) {
		return car.getId();
	}

	@Override
	public String toString() {
		return "CarInMemoryDAO [map=" + map + "]";
	}

}
