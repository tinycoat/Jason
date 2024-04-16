package com.algorithm.Recursion.MiGong;

public class MiGongDemo {
    public static void main(String[] args) {
        // 创建迷宫
        char[][] map = new char[8][8];
        for (int i = 0; i < 8; i++) {
            map[i][0] = '1';
            map[i][7] = '1';
            map[0][i] = '1';
            map[7][i] = '1';
        }
        map[3][1] = '1';
        map[3][2] = '1';
        System.out.println("迷宫：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("  " + map[i][j]);
            }
            System.out.println();
        }

        solve(map, 1, 1);

        System.out.println("处理后的迷宫：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("  " + map[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯给小球找路(下右上左)，右下角(7,7)为出口
     * 墙壁 - 1
     * 未走过 - 0
     * 走过可通 - *
     * 走过但不通 - +
     * @param map 迷宫地图
     * @param i 起始坐标
     * @param j 起始坐标
     * @return 找到通路返回true
     */
    public static boolean solve(char[][] map, int i, int j) {
        if (map[6][6] == '*') { // 到达终点
            return true;
        } else {
            if (map[i][j] == '\u0000') { // 点没走过
                map[i][j] = '*';
                if (solve(map, i + 1, j)) { // 下
                    return true;
                } else if (solve(map, i, j + 1)) { // 右
                    return true;
                } else if (solve(map, i - 1, j)) { // 上
                    return true;
                } else if (solve(map, i, j - 1)) { // 左
                    return true;
                } else {
                    map[i][j] = '+';
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
