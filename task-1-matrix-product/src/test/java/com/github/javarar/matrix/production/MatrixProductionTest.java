package com.github.javarar.matrix.production;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixProductionTest {

    @Test
    public void validateMatrixProduction() {
        int[][] a = {
                { 1, 1, 1 },
                { 2, 2, 2 },
                { 3, 3, 3 },
                { 4, 4, 4 }
        };

        int[][] b = {
                { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 }
        };

        int[][] expected = {
                {6, 6, 6, 6 },
                {12, 12, 12, 12 },
                {18, 18, 18, 18 },
                {24, 24, 24, 24 }
        };


        int rowA = 4, colA = 3, rowB = 3, colB = 4;
        int[][] result = MatrixProduction.product(rowA, colA, a, rowB, colB, b);

        assertArrayEquals(expected, result);
    }

    @Test
    public void validateMatrixProduction2() {
        int[][] a = {
                { 1, 1, 1 },
                { 2, 2, 2 },
                { 3, 3, 3 }
        };

        int[][] b = {
                { 1, 1, 1 },
                { 2, 2, 2 },
                { 3, 3, 3 }
        };

        int[][] expected = {
                {6, 6, 6 },
                {12, 12, 12 },
                {18, 18, 18 }
        };

        int rowA = 3, colA = 3, rowB = 3, colB = 3;
        int[][] result = MatrixProduction.product(rowA, colA, a, rowB, colB, b);

        assertArrayEquals(expected, result);
    }

}
