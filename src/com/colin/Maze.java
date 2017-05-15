package com.colin;

import com.colin.model.Pos;

import java.util.HashSet;
import java.util.Set;

/**
 * e30
 * 迷宫问题
 * 把迷宫抽象成 若干个节点组成的图，出口入口就是求A到B点的路径
 *
 * Created by Colin on 2017/5/14.
 */
public class Maze {

    private Pos entry;
    private Pos exit;
    private Set<Pos> solve;

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.show();
        Set<Pos> traveled = new HashSet<>();
        maze.go(maze.entry, traveled);
        maze.show();
    }

    public Maze() {
        solve = new HashSet<>();
        getStdInput();
    }

    private char[][] data;

    private void getStdInput() {
        String[] x = {
                "####B#######",
                "####    ####",
                "#### ####  #",
                "# ## ##### #",
                "#    ##### #",
                "# ##       #",
                "# ## ### # #",
                "## # ### # Expression",
                "## ###   ###",
                "############"
        };
        data = new char[x.length][];
        for (int i = 0; i < data.length; i++) {
            data[i] = x[i].toCharArray();
            for (int j = 0; j < data[i].length; j++) {
                char c = data[i][j];
                if (c == 'B') {
                    entry = new Pos(i, j);
                } else if (c == 'A') {
                    exit = new Pos(i, j);
                }
            }
        }
    }

    /**
     * 深度优先遍历
     * @param cur
     * @param path
     * @return
     */
    private boolean go(Pos cur, Set path) {
        if (cur.equals(exit)) {
            return true;
        }
        path.add(cur);

        Pos[] neighbours = new Pos[]{//上下左右节点
                new Pos(cur.i, cur.j - 1),
                new Pos(cur.i, cur.j + 1),
                new Pos(cur.i - 1, cur.j),
                new Pos(cur.i + 1, cur.j)
        };

        for (int i = 0; i < neighbours.length; i++) {
            Pos pos = neighbours[i];
            try {
                if (data[pos.i][pos.j] != '#' && path.contains(pos) == false) {//有通路
                    if (go(pos, path)) {//递归调用
                        solve.add(cur);
                        return true;
                    }
                }
            } catch (Exception e) {

            }
        }
        return false;
    }

    public void show() {
        for (int i = 0; i < data.length; i++) {
            char[] line = data[i];
            for (int j = 0; j < line.length; j++) {
                char c = line[j];
                if (solve.contains(new Pos(i, j))) {
                    c = 'X';
                }
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();

    }
}
