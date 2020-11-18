package hu.unideb.prog2.webshop.command.impl;

import hu.unideb.prog2.webshop.dao.DataAccessObject;
import hu.unideb.prog2.webshop.dao.impl.ProductTypeDAO;
import hu.unideb.prog2.webshop.model.ProductType;

public class AdminProductTypeAddCommand extends AbstractCommand {

	private DataAccessObject<ProductType> productTypeDAO;
	
	public AdminProductTypeAddCommand(DataAccessObject<ProductType> productTypeDAO) {
		super("admin", "product_type", "add");
		this.productTypeDAO = productTypeDAO;
	}

	@Override
	public String process(String commandString) {
		productTypeDAO.create(new ProductType("", "", "", 1000));
		return "AdminProductTypeAddCommand is called";
	}

}
