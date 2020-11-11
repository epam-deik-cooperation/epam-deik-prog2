package hu.unideb.prog2.webshop.command.impl;

import hu.unideb.prog2.webshop.dao.impl.ProductTypeDAO;

public class AdminProductTypeListCommand extends AbstractCommand {

	private ProductTypeDAO productTypeDAO;
	
	public AdminProductTypeListCommand(ProductTypeDAO productTypeDAO) {
		super("admin", "product_type", "list");
		this.productTypeDAO = productTypeDAO;
	}

	@Override
	public String process(String commandString) {
		return productTypeDAO.list().toString();
	}

}
