package com.epam.training.asciiprinter;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

public class AsciiPrinter {

	private static final char[] ASCII_PIXELS = { '$', '#', '*', ':', '.', ' ' };
	private static final byte[] NEW_LINE = "\n".getBytes();

	private OutputStream outputStream;
	private BufferedImage image;

	public AsciiPrinter(OutputStream outputStream, BufferedImage image) {
		super();
		this.outputStream = outputStream;
		this.image = image;
	}

	public void print() throws IOException {
		for (int i = 0; i < image.getHeight(); i++) {
			for (int j = 0; j < image.getWidth(); j++) {
				outputStream.write(getAsciiChar(image.getRGB(j, i)));
			}
			outputStream.write(NEW_LINE);
		}
	}

	public static char getAsciiChar(int pixel) {
		return getAsciiCharFromGrayScale(getGreyScale(pixel));
	}

	public static int getGreyScale(int argb) {
		int red = (argb >> 16) & 0xff;
		int green = (argb >> 8) & 0xff;
		int blue = (argb) & 0xff;
		return (red + green + blue) / 3;
	}

	public static char getAsciiCharFromGrayScale(int greyScale) {
		return ASCII_PIXELS[greyScale / 51];
	}

}
