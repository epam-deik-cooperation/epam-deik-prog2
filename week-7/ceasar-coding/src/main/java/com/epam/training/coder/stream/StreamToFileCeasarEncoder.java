package com.epam.training.coder.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.epam.training.coder.ceasar.CeasarCoder;

public class StreamToFileCeasarEncoder extends StreamEncoder {

	public StreamToFileCeasarEncoder(InputStream inputStream, String fileName, int offset) throws FileNotFoundException {
		super(inputStream, new FileOutputStream(fileName), new CeasarCoder(offset));
	}
	
}
