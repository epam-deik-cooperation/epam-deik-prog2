package com.epam.training.dao.car;

import java.util.Objects;

public class Car {

	private final long id;
	private final String brand;
	private final String type;

	public Car(long id, String brand, String type) {
		super();
		this.id = id;
		this.brand = brand;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, id, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Car)) {
			return false;
		}
		Car other = (Car) obj;
		return Objects.equals(brand, other.brand) && id == other.id && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", type=" + type + "]";
	}

}
