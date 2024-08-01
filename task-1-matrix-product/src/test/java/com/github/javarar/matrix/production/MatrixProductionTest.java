package com.github.javarar.matrix.production;

import com.github.javarar.matrix.production.MatrixProduction.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MatrixProductionTest {

    @DisplayName("Задание 2. Вычисление произведения квадратных матриц")
    @ParameterizedTest
    @MethodSource("matrixProducer")
    public void validateMatrixProduction(Matrix a, Matrix b) {
        throw new UnsupportedOperationException("реализуй меня");
    }

    private static Stream<Arguments> matrixProducer() {
        throw new UnsupportedOperationException("реализуй меня");
    }
}
