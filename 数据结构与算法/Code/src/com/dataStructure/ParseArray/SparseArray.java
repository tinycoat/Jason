package com.dataStructure.ParseArray;

/*
 *   五子棋棋盘是二维数组，使用稀疏数组保存
 */

public class SparseArray {
    public static void main(String[] args) {
        // 原二维数组数据呈现 11 * 11，0表示没有棋子，1表示黑子，2表示白子，只有（2，3）黑，（3，4）白
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始棋盘二维数组呈现：");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 使用稀疏数组存储
        //  序号      行       列       值
        //   0       11       11       2
        //   1        1        2       1
        //   2        2        3       2

        // 遍历原数组求有数据的点数
        int sum = 0;
        for (int[] item : chessArr1) {
            for (int data : item) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        // 创建稀疏数组[sum + 1][3]
        int[][] sparseArr = new int[sum + 1][3];
        // 稀疏数组第0条数据存储数组维度和数据量
        int count = 0;
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;
        // 遍历数组存储非零点的坐标和值
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println("记录为稀疏数组为：");
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }

        // 从稀疏数组sparseArr恢复为二维数组chessArr2
        // 从稀疏数组第0条数据创建原始二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 遍历稀疏数组，将每个数据点根据坐标进行赋值
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("从稀疏数组恢复出的二维数组：");
        for (int i = 0; i < chessArr2.length; i++) {
            for (int j = 0; j < chessArr2[i].length; j++) {
                System.out.printf("%d\t", chessArr2[i][j]);
            }
            System.out.println();
        }
    }
}
