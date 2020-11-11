package hu.unideb.prog2.webshop.command.impl;

public class AdminProductTypeImportCommand extends AbstractCommand {

	public AdminProductTypeImportCommand() {
		super("admin", "product_type", "import");
	}

	@Override
	public String process(String commandString) {
		return "AdminProductTypeImportCommand is called";
	}

}
