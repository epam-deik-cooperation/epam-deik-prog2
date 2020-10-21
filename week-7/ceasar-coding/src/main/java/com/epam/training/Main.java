package com.epam.training;

import java.io.IOException;

import com.epam.training.coder.stream.ConsoleInputToFileCeasarEncoder;
import com.epam.training.coder.stream.StreamEncoder;

public class Main {

	public static void main(String[] args) throws IOException {
		String fileName = args[0];
		int offset = Integer.valueOf(args[1]);
		try (StreamEncoder handler = new ConsoleInputToFileCeasarEncoder(fileName, offset)) {
			handler.handleInputs();
		}
	}

}
