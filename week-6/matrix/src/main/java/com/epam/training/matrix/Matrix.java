package com.epam.training.matrix;

public interface Matrix {

	void setElement(int x, int y, int value);

	Matrix multiply(Matrix input);

}
