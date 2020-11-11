package hu.unideb.prog2.webshop.command.impl;

public class BaseCommand extends AbstractCommand {

	public BaseCommand(String userType, String entityType, String action) {
		super(userType, entityType, action);
	}

	@Override
	public String process(String commandString) {
		throw new UnsupportedOperationException();
	}

}
