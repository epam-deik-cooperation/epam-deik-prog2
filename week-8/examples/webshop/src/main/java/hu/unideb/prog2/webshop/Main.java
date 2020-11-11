package hu.unideb.prog2.webshop;

import hu.unideb.prog2.webshop.controller.UserInteractionController;
import hu.unideb.prog2.webshop.controller.UserInteractionControllerFactory;

public class Main {

	public static void main(String[] args) {
		try (UserInteractionController controller = UserInteractionControllerFactory.create(System.in, System.out)) {
			controller.handleUserInputs();
		} catch (Exception e) {
			e.printStackTrace();
		};
	}

}