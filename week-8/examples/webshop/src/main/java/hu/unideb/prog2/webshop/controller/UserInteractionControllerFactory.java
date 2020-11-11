package hu.unideb.prog2.webshop.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

import hu.unideb.prog2.webshop.command.impl.AbstractCommand;
import hu.unideb.prog2.webshop.command.impl.AdminProductTypeAddCommand;
import hu.unideb.prog2.webshop.command.impl.AdminProductTypeImportCommand;
import hu.unideb.prog2.webshop.command.impl.AdminProductTypeListCommand;
import hu.unideb.prog2.webshop.dao.impl.ProductTypeDAO;

public class UserInteractionControllerFactory {

	public static UserInteractionController create(InputStream input, OutputStream output) {
		// DAO creation
		ProductTypeDAO productTypeDAO = new ProductTypeDAO();
		
		// Command creation
		Set<AbstractCommand> commands = new HashSet<>();
		commands.add(new AdminProductTypeImportCommand());
		commands.add(new AdminProductTypeListCommand(productTypeDAO));
		commands.add(new AdminProductTypeAddCommand(productTypeDAO));
		
		return new UserInteractionController(input, output, commands);
	}
	
}
