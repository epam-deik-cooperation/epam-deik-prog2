package com.epam.training.coder.ceasar;

import java.util.function.Function;

import com.epam.training.coder.Decoder;
import com.epam.training.coder.Encoder;

public class CeasarCoder implements Encoder, Decoder {

	private final int offset;

	public CeasarCoder(int offset) {
		if (offset < 1 || offset > 127) {
			throw new IllegalArgumentException("Offset must be between 1 and 127");
		}
		this.offset = offset;
	}

	public CeasarCoder() {
		this.offset = 1;
	}

	@Override
	public String decode(String text) {
		return buildString(text, character -> (char) ((character - offset) % 128));
	}

	@Override
	public String encode(String text) {
		return buildString(text, character -> (char) ((character + offset) % 128));
	}

	private String buildString(String text, Function<Character, Character> function) {
		StringBuilder result = new StringBuilder();
		for (char character : text.toCharArray()) {
			if (character != ' ') {
				result.append(function.apply(character));
			} else {
				result.append(character);
			}
		}
		return result.toString();
	}

}
