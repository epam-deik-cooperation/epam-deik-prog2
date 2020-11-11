package hu.unideb.prog2.webshop.command.impl;

import hu.unideb.prog2.webshop.dao.impl.ProductTypeDAO;
import hu.unideb.prog2.webshop.model.ProductType;

public class AdminProductTypeAddCommand extends AbstractCommand {

	private ProductTypeDAO productTypeDAO;
	
	public AdminProductTypeAddCommand(ProductTypeDAO productTypeDAO) {
		super("admin", "product_type", "add");
		this.productTypeDAO = productTypeDAO;
	}

	@Override
	public String process(String commandString) {
		productTypeDAO.create(new ProductType("", "", "", 1000));
		return "AdminProductTypeAddCommand is called";
	}

}
