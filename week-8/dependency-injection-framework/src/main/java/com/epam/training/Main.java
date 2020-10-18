package com.epam.training;

import com.epam.training.di.Configuration;
import com.epam.training.di.DiContext;
import com.epam.training.di.annotation.Bean;
import com.epam.training.di.annotation.Qualifier;
import com.epam.training.di.impl.DiContextBuilder;

public class Main {
	
	public static void main(String[] args) {
		DiContext context = new DiContextBuilder().build(new Main.ContextConfig());
		System.out.println(context.getBean("stringBuilder", StringBuilder.class).get().toString());
	}

	public static class ContextConfig implements Configuration {
		
		@Bean
		public String stringBeanA() {
			return "StringA";
		}

		@Bean
		public String stringBeanB() {
			return "StringB";
		}
		
		@Bean
		public Integer integerBean() {
			return 10;
		}
		
		@Bean
		public StringBuilder stringBuilder(@Qualifier(name = "stringBeanA") String string, Integer integer) {
			return new StringBuilder(string).append(integer);
		}
		
	}
	
}
