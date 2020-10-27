package com.epam.training.matrix.impl;

import com.epam.training.matrix.Matrix;

public class ForMatrix extends AbstractMatrix {

	public ForMatrix(int[][] matrix) {
		super(matrix);
	}

	public ForMatrix(int rowsLenght, int columnsLenght) {
		super(rowsLenght, columnsLenght);
	}

	public Matrix multiply(AbstractMatrix input) {
		int[][] result = new int[this.rowsLenght][input.columnsLenght];

		for (int row = 0; row < result.length; row++) {
			for (int col = 0; col < result[row].length; col++) {
				result[row][col] = multiplyMatricesCell(this.matrix, input.matrix, row, col);
			}
		}

		return new ForMatrix(result);
	}

	private int multiplyMatricesCell(int[][] firstMatrix, int[][] secondMatrix, int row, int col) {
		int cell = 0;
		for (int i = 0; i < secondMatrix.length; i++) {
			cell += firstMatrix[row][i] * secondMatrix[i][col];
		}
		return cell;
	}

}
