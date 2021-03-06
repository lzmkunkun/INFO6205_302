package com.team302;

import UI.ShowJFrame;

import java.util.concurrent.CompletableFuture;

public class Main {

//        public static final int[][] skd =
//                   {{7, 0, 0, 9, 0, 0, 0, 0, 1},
//                    {1, 0, 0, 0, 0, 5, 9, 0, 0},
//                    {0, 0, 0, 2, 0, 0, 0, 8, 0},
//                    {0, 0, 5, 0, 2, 0, 0, 0, 3},
//                    {0, 0, 0, 0, 0, 0, 6, 4, 8},
//                    {4, 1, 3, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 7, 0, 0, 2, 0, 9, 0},
//                    {2, 0, 1, 0, 6, 0, 8, 0, 4},
//                    {0, 8, 0, 5, 0, 4, 0, 1, 2}};

    public static final int[][] skd =
                   {{0, 0, 0, 7, 0, 2, 4, 5, 3},
                    {9, 0, 0, 0, 0, 8, 0, 0, 0},
                    {7, 4, 0, 0, 0, 5, 0, 1, 0},
                    {1, 9, 5, 0, 8, 0, 0, 0, 0},
                    {0, 7, 0, 0, 0, 0, 0, 2, 5},
                    {0, 3, 0, 5, 7, 9, 1, 0, 8},
                    {0, 0, 0, 6, 0, 1, 0, 0, 0},
                    {0, 6, 0, 9, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 6}};

//    public static final int[][] skd =
//                   {{0, 3, 0, 5, 0, 0, 0, 0, 8},
//                    {0, 4, 8, 3, 6, 1, 9, 7, 0},
//                    {0, 0, 0, 0, 0, 8, 0, 0, 0},
//                    {8, 6, 0, 0, 4, 0, 0, 1, 2},
//                    {0, 2, 4, 8, 0, 6, 0, 0, 0},
//                    {0, 1, 0, 9, 3, 0, 0, 6, 0},
//                    {7, 9, 3, 0, 0, 0, 1, 8, 0},
//                    {0, 8, 0, 0, 0, 0, 2, 5, 3},
//                    {6, 5, 2, 1, 0, 0, 7, 0, 0}};

//    public static final int[][] skd =
//                    {{0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0}};

//    public static final int[][] skd =
//                    {{0, 0, 3, 0, 0, 0, 0, 0, 0},
//                    {8, 0, 9, 4, 6, 0, 7, 0, 2},
//                    {2, 0, 0, 0, 1, 8, 6, 0, 0},
//                    {0, 0, 0, 0, 0, 6, 0, 0, 7},
//                    {0, 0, 8, 0, 0, 0, 4, 0, 0},
//                    {0, 7, 0, 8, 0, 0, 0, 0, 0},
//                    {0, 0, 2, 9, 4, 0, 0, 0, 5},
//                    {4, 0, 6, 0, 3, 2, 8, 0, 7},
//                    {0, 0, 0, 0, 0, 0, 2, 0, 0}};
    public static void init() {
        Sudoku.index[0] = 0;
        Sudoku.unused = 0;
        boolean[] avail;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                int count = 0;
                avail = new boolean[10];
                for (int a = 0; a < 3; a++)
                    for (int b = 0; b < 3; b++)
                        if (skd[i * 3 + a][j * 3 + b] == 0) {
                            Sudoku.unused++;
                            count++;
                        } else avail[skd[i * 3 + a][j * 3 + b]] = true;
                Sudoku.index[i * 3 + j + 1] = Sudoku.index[i * 3 + j] + count;
                int ind = 0;
                Sudoku.codeFrag[i * 3 + j] = new int[count];
                for (int k = 1; k <= 9; k++)
                    if (!avail[k]) Sudoku.codeFrag[i * 3 + j][ind++] = k;
            }


    }
    public static void main(String[] args) {
        init();
        ParGA parGA = new ParGA();
        parGA.go();
    }
}
