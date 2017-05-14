package com.colin;

/**
 * e29
 * 试探与回溯
 * <p>
 * 串联电路 若干个开关，怎么操作使所有的开关闭合让灯泡亮起来
 * <p>
 * 回溯：枚举不重复、不遗漏
 * 八皇后问题    8X8棋盘中放入8个皇后，使之不会相互攻击（不在同一行、同一列、同一对角线上）
 * Created by Colin on 2017/5/14.
 */
public class EightQueens {

    public static int n;

    public static void main(String[] args) {
        int columns[] = new int[8];//已知每个皇后肯定不在同一行，所以问题简化为 8个皇后分别放在哪一列
        place(columns, 0);//从第0行皇后开始
        System.out.println(n);
    }

    /**
     * @param columns 8列
     * @param k       第k个皇后,相当于行数
     */
    public static void place(int[] columns, int k) {
        if (k >= 8) {
            Utils.printArray(columns);
            n++;
            return;
        }
        for (int i = 0; i < columns.length; i++) {
            columns[k] = i;
            if (check(columns, k, i)) {
                place(columns, k + 1);//从k+1行开始放皇后
            }
        }
    }

    private static boolean check(int[] columns, int row, int column) {
        for (int j = 0; j < row; j++) {
            if (column == columns[j])//该列已经有其他皇后
                return false;
            if (row - j == Math.abs(column - columns[j]))//两个棋子的 行数差和列数差都相等，说明在同一对角线上
                return false;
        }
        return true;
    }
}
