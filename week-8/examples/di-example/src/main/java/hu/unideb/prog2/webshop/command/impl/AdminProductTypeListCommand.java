package hu.unideb.prog2.webshop.command.impl;

import hu.unideb.prog2.webshop.dao.DataAccessObject;
import hu.unideb.prog2.webshop.dao.impl.ProductTypeDAO;
import hu.unideb.prog2.webshop.model.ProductType;

public class AdminProductTypeListCommand extends AbstractCommand {

	private DataAccessObject<ProductType> productTypeDAO;
	
	public AdminProductTypeListCommand(DataAccessObject<ProductType> productTypeDAO) {
		super("admin", "product_type", "list");
		this.productTypeDAO = productTypeDAO;
	}

	@Override
	public String process(String commandString) {
		return productTypeDAO.list().toString();
	}

}
