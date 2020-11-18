package hu.unideb.prog2.webshop.configuration;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

import hu.unideb.prog2.di.annotation.Bean;
import hu.unideb.prog2.webshop.command.impl.AbstractCommand;
import hu.unideb.prog2.webshop.command.impl.AdminProductTypeAddCommand;
import hu.unideb.prog2.webshop.command.impl.AdminProductTypeImportCommand;
import hu.unideb.prog2.webshop.command.impl.AdminProductTypeListCommand;
import hu.unideb.prog2.webshop.controller.UserInteractionController;
import hu.unideb.prog2.webshop.dao.DataAccessObject;
import hu.unideb.prog2.webshop.dao.impl.ProductTypeDAO;
import hu.unideb.prog2.webshop.model.ProductType;

public class WebshopAppConfiguration {

	@Bean
	public static InputStream input() {
		return System.in;
	}

	@Bean
	public static OutputStream output() {
		return System.out;
	}

	@Bean
	public static ProductTypeDAO productTypeDao() {
		return new ProductTypeDAO();
	}

	@Bean
	public static Set<AbstractCommand> commands(DataAccessObject<ProductType> productTypeDAO) {
		Set<AbstractCommand> commands = new HashSet<>();
		commands.add(new AdminProductTypeImportCommand());
		commands.add(new AdminProductTypeListCommand(productTypeDAO));
		commands.add(new AdminProductTypeAddCommand(productTypeDAO));
		return commands;
	}

	@Bean
	public static UserInteractionController userInteractionController(InputStream input, OutputStream output, Set<AbstractCommand> commands) {
		return new UserInteractionController(input, output, commands);
	}
	
}
