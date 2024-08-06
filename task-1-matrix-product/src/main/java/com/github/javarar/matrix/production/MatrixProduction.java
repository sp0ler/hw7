package com.github.javarar.matrix.production;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MatrixProduction {

    public static int[][] product(
            int rowA, int colA, int[][] a,
            int rowB, int colB, int[][] b)
    {
        if (rowB != colA) {
            throw new IllegalArgumentException("Невозможно посчитать произведение матриц!");
        }

        int[][] c = new int[rowA][colB];
        List<CompletableFuture<Void>> futures = new ArrayList<>(a.length * b.length);

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < rowB; k++) {
                    int finalI = i;
                    int finalJ = j;
                    int finalK = k;

                    futures.add(
                            CompletableFuture.runAsync(() -> {
                                c[finalI][finalJ] += a[finalI][finalK] * b[finalK][finalJ];
                            })
                    );
                }
            }
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        return c;
    }
}
