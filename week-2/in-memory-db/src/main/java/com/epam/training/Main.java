package com.epam.training;

import com.epam.training.dao.DataAccessObject;
import com.epam.training.dao.car.Car;
import com.epam.training.dao.car.CarInMemoryDao;

public class Main {

	public static void main(String[] args) {
		DataAccessObject<Car, Long> carDAO = new CarInMemoryDao();
		Car car1 = new Car(1, "Toyota", "Yaris");
		Car car2 = new Car(2, "Nissan", "Note");

		// Add cars to the In Memory "Database"
		carDAO.save(car1);
		carDAO.save(car2);
		System.out.println(carDAO);

		// Remove one of the stored car
		carDAO.delete(1L);
		System.out.println(carDAO);

		// Retrieve the remaining stored Car object
		System.out.println(carDAO.get(2L));

		// Update the remaining Car
		carDAO.update(new Car(2, "Nissan", "Leaf"));
		System.out.println(carDAO.get(2L));
	}

}
