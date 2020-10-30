package com.epam.training.coder.stream;

import java.io.FileNotFoundException;

public class ConsoleInputToFileCeasarEncoder extends StreamToFileCeasarEncoder {

	public ConsoleInputToFileCeasarEncoder(String fileName, int offset)
			throws FileNotFoundException {
		super(System.in, fileName, offset);
	}

}
