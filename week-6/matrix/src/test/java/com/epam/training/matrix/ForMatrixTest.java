package com.epam.training.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.epam.training.matrix.impl.ForMatrix;

public class ForMatrixTest {

    @Test
    public void testMultiplyShouldReturnWithCorrectValue() {
        // Given
        Matrix matrixA = new ForMatrix(new int[][] {{1, 5},
                                                    {2, 3},
                                                    {1, 7}});
        Matrix matrixB = new ForMatrix(new int[][] {{1, 2, 3, 7},
                                                    {5, 2, 8, 1}});
        Matrix expected = new ForMatrix(new int[][] {{26, 12, 43, 12},
                                                     {17, 10, 30, 17},
                                                     {36, 16, 59, 14}});
        
        // When
        Matrix actual = matrixA.multiply(matrixB);
        
        // Then
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSetElementShouldSetTheRightCoordinateOfTheMatrix() {
        // Given
        Matrix matrix = new ForMatrix(2, 3);
        Matrix expected = new ForMatrix(new int[][] {{0, 0, 0},
                                                     {0, 0, 5}});
        
        // When
        matrix.setElement(1, 2, 5);;
        
        // Then
        assertEquals(expected, matrix);
    }
    
}
