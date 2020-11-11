package hu.unideb.prog2.webshop.model;

public class ProductType {

	private String category;
	private String brand;
	private String model;
	private Integer price;
	
	public ProductType(String category, String brand, String model, Integer price) {
		super();
		this.category = category;
		this.brand = brand;
		this.model = model;
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public Integer getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ProductType)) {
			return false;
		}
		ProductType other = (ProductType) obj;
		if (brand == null) {
			if (other.brand != null) {
				return false;
			}
		} else if (!brand.equals(other.brand)) {
			return false;
		}
		if (category == null) {
			if (other.category != null) {
				return false;
			}
		} else if (!category.equals(other.category)) {
			return false;
		}
		if (model == null) {
			if (other.model != null) {
				return false;
			}
		} else if (!model.equals(other.model)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ProductType [category=" + category + ", brand=" + brand + ", model=" + model + ", price=" + price + "]";
	}
	
}
