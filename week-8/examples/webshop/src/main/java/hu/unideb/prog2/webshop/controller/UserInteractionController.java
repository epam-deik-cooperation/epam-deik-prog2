package hu.unideb.prog2.webshop.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import hu.unideb.prog2.webshop.command.impl.AbstractCommand;
import hu.unideb.prog2.webshop.command.impl.BaseCommand;

public class UserInteractionController implements AutoCloseable {

	private Scanner scanner;
	private OutputStream output;
	private Set<AbstractCommand> commands;
	
	public UserInteractionController(InputStream input, OutputStream output, Set<AbstractCommand> commands) {
		if (input == null) {
			throw new NullPointerException("Input is a mandatory parameter");
		}
		if (output == null) {
			throw new NullPointerException("Output is a mandatory parameter");
		}
		this.scanner = new Scanner(input);
		this.output = output;
		this.commands = commands;
	}
	
	public void handleUserInputs() throws IOException {
		String inputLine = null;
		do {
			inputLine = scanner.nextLine();
			String[] commandParts = inputLine.split(" ");
			if (commandParts.length < 3) {
				throw new IllegalArgumentException("Invalid command: " + inputLine);
			}
			AbstractCommand abstractCommand = new BaseCommand(commandParts[0], commandParts[1], commandParts[2]);
			Optional<AbstractCommand> optionalCommand = commands.stream().filter(command -> command.equals(abstractCommand)).findFirst();
			if(optionalCommand.isEmpty()) {
				throw new IllegalArgumentException("Unknown command");
			}
			output.write(optionalCommand.get().process(null).getBytes());
		} while (!inputLine.equals("exit"));
	}

	@Override
	public void close() throws Exception {
		scanner.close();
		output.close();
	}
	
}
