package hu.unideb.prog2.webshop;

import hu.unideb.prog2.di.Context;
import hu.unideb.prog2.di.annotation.Bean;
import hu.unideb.prog2.di.defaultcontext.ConfigurationClassBasedBeanDefinitionLoader;
import hu.unideb.prog2.di.defaultcontext.DefaultContext;
import hu.unideb.prog2.webshop.configuration.WebshopAppConfiguration;
import hu.unideb.prog2.webshop.controller.UserInteractionController;

public class Main {

	public static void main(String[] args) {
		Context applicationContext = new DefaultContext(
				new ConfigurationClassBasedBeanDefinitionLoader(WebshopAppConfiguration.class));
		try (UserInteractionController controller = applicationContext.getBeanForType(UserInteractionController.class)) {
			controller.handleUserInputs();
		} catch (Exception e) {
			e.printStackTrace();
		};
	}

}