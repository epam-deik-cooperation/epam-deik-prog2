package com.epam.training.matrix.impl;

import java.util.Arrays;
import java.util.stream.IntStream;

import com.epam.training.matrix.Matrix;

public class LambdaMatrix extends AbstractMatrix {

	public LambdaMatrix(int[][] matrix) {
		super(matrix);
	}

	public LambdaMatrix(int rowsLenght, int columnsLenght) {
		super(rowsLenght, columnsLenght);
	}

	@Override
	protected Matrix multiply(AbstractMatrix input) {
		int[][] result = Arrays.stream(this.matrix)
				.map(r -> IntStream.range(0, input.columnsLenght)
						.map(i -> IntStream.range(0, input.rowsLenght).map(j -> r[j] * input.matrix[j][i]).sum())
						.toArray())
				.toArray(int[][]::new);
		return new LambdaMatrix(result);
	}

}
