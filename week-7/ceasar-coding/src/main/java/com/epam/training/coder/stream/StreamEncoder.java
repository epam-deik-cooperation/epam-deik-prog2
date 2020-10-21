package com.epam.training.coder.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import com.epam.training.coder.Encoder;

public class StreamEncoder implements AutoCloseable {

	private static final byte[] NEW_LINE = "\n".getBytes();
	
	private Scanner inputScanner;
	private OutputStream outputStream;
	private Encoder encoder;

	public StreamEncoder(InputStream inputStream, OutputStream outputStream, Encoder encoder) {
		this.inputScanner = new Scanner(inputStream);
		this.outputStream = outputStream;
		this.encoder = encoder;
	}

	public void handleInputs() throws IOException {
		String line;
		do {
			line = inputScanner.nextLine();
			String encodedLine = encoder.encode(line);
			outputStream.write(encodedLine.getBytes());
			outputStream.write(NEW_LINE);
		} while (!"exit".equals(line));
	}

	@Override
	public void close() throws IOException {
		inputScanner.close();
		outputStream.close();
	}

}
