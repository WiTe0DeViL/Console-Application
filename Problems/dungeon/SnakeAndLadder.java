package dungeon;

import java.util.LinkedList;
import java.util.Queue;

class SnakeAndLadder {
    class Cell {
        int index;
        int hop;
    }

    public static void main(String[] args) {
//        int[][] board = {
//                {-1, -1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, 35, -1, -1, 13, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, 15, -1, -1, -1, -1}};
        int[][] board = {
                {-1,-1,-1},
                {-1,9,-1},
                {-1,-1,5}};
        SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
        System.out.println(snakeAndLadder.snakesAndLadders(board));
    }

    public int snakesAndLadders(int[][] board) {
        int[] arr = fillArray(board);
        boolean[] visited = new boolean[arr.length];
        Queue<Cell> q = new LinkedList<>();
        Cell firstCell = new Cell();
        firstCell.index = 0;
        firstCell.hop = 0;
        q.offer(firstCell);
        Cell temp = null;
        while (!q.isEmpty()) {
            temp = q.poll();
            int index = temp.index;
            if (index == arr.length - 1) {
                print(q);
                break;
            }
            for (int i = index + 1; (i <= (index + 6)) && (i < arr.length); i++) {
                if (!visited[i]) {
                    Cell newCell = new Cell();
                    newCell.hop = temp.hop + 1;
                    visited[i] = true;
                    if (arr[i] != -1)
                        newCell.index = arr[i];
                    else
                        newCell.index = i;
                    q.offer(newCell);
                }
            }
        }
        return temp.hop;

    }

    public void print(Queue<Cell> q) {
        for (Cell c : q) {
            System.out.println("index -> " + c.index + " hop -> " + c.hop);
        }
    }

    public int[] fillArray(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n];
        int index = 0;
        boolean rev = false;
        for (int i = board.length - 1; i >= 0; i--) {
            if (rev) {
                for (int j = board.length; j >= 0; j--) {
                    arr[index++] = board[i][j];
                }
            } else {
                for (int j = 0; j < board.length; j++) {
                    arr[index++] = board[i][j];
                }
            }
        }
        return arr;
    }

}