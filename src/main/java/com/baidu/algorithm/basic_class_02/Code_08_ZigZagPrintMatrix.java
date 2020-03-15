package com.baidu.algorithm.basic_class_02;

/**
 * 之字形打印矩阵
 * 要求：额外空间复杂度为O(1)
 * 宏观思路 + 具体实现
 */
public class Code_08_ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (aR != endR + 1) {
            printLevel(matrix, aR, aC, bR, bC, fromUp);
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            bR = bR == endR ? bR : bR + 1;
            bC = bR == endR ? bC + 1 : bC;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void printLevel(int[][] m, int aR, int aC, int bR, int bC,
            boolean f) {
        // f = false, 从上向下打印
        if (f) {
            while (aR != bR + 1) {
                System.out.print(m[aR++][aC--] + " ");
            }
        } else {
        // f = true, 从下向上打印
            while (bR != aR - 1) {
                System.out.print(m[bR--][bC++] + " ");
            }
        }
    }
}
