package com.epam.training;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.epam.training.asciiprinter.AsciiPrinter;

public class Main {

	public static void main(String[] args) throws IOException {
		String imageName = args[0];
		String textFileName = args.length != 2 ? null : args[1];
		OutputStream outputStream = textFileName == null ? System.out : new FileOutputStream(textFileName);
		BufferedImage image = ImageIO.read(new File(imageName));

		new AsciiPrinter(outputStream, image).print();
	}

}
