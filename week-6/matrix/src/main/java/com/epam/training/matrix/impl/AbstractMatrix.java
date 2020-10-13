package com.epam.training.matrix.impl;

import java.util.Arrays;

import com.epam.training.matrix.Matrix;

public abstract class AbstractMatrix implements Matrix {

	protected final int[][] matrix;
	protected final int rowsLenght;
	protected final int columnsLenght;

	public AbstractMatrix(int[][] matrix) {
		this.matrix = matrix;
		this.rowsLenght = matrix.length;
		this.columnsLenght = matrix[0].length;
	}

	public AbstractMatrix(int rowsLenght, int columnsLenght) {
		this.matrix = new int[rowsLenght][columnsLenght];
		this.rowsLenght = rowsLenght;
		this.columnsLenght = columnsLenght;
	}

	@Override
	public void setElement(int x, int y, int value) {
		matrix[x][y] = value;
	}

	@Override
	public Matrix multiply(Matrix input) {
		if (input instanceof AbstractMatrix) {
			return multiply((AbstractMatrix) input);
		}
		throw new IllegalArgumentException("The input matrix should be an instance of AbstractMatrix");
	}

	abstract protected Matrix multiply(AbstractMatrix input);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columnsLenght;
		result = prime * result + Arrays.deepHashCode(matrix);
		result = prime * result + rowsLenght;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AbstractMatrix)) {
			return false;
		}
		AbstractMatrix other = (AbstractMatrix) obj;
		if (columnsLenght != other.columnsLenght) {
			return false;
		}
		if (!Arrays.deepEquals(matrix, other.matrix)) {
			return false;
		}
		if (rowsLenght != other.rowsLenght) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Matrix [matrix=" + Arrays.toString(matrix) + ", rowsLenght=" + rowsLenght + ", columnsLenght="
				+ columnsLenght + "]";
	}

}
