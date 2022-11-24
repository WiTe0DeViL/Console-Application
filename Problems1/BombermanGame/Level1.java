package BombermanGame;

import java.util.HashMap;
import java.util.Scanner;

public class Level1 {

    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.print("Enter the size of the matrix in even : ");
        int n = scan.nextInt();
        char[][] map = new char[n][n];

        fillMapWithSpace(map);
        /*
        P - Player
        * - Wall
        B - brick
        V - Villain
        k - key
         */
//        System.out.println(index);
        char rowColumCoordinate = 'A';
        fill(map, rowColumCoordinate);
        displayMap(map);
        Placing placing = new Placing(n);
        placing.getPlayerPosition(map);
        placing.getKeyposition(map);
        System.out.print("Enter number of villains : ");
        int villains = scan.nextInt();
        while (villains > 0) {
            placing.getVillains(map);
            villains--;
        }
        System.out.print("Enter number of Bricks : ");
        int Bricks = scan.nextInt();
        while (Bricks > 0) {
            placing.getBricks(map);
            Bricks--;
        }
        displayMap(map);
    }


    private static void fillMapWithSpace(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++)
                map[i][j] = ' ';
        }
    }

    private static void displayMap(char[][] map) {
        for (char[] x : map) {
            for (char y : x)
                System.out.print(y + " ");
            System.out.println();
        }
    }

    private static void fill(char[][] map, char rowColumCoordinate) {
        for (int i = 1; i < map.length; i++) {
            map[i][0] = rowColumCoordinate++;
        }
        rowColumCoordinate = 'A';
        for (int i = 1; i < map.length; i++) {
            map[0][i] = rowColumCoordinate++;
        }
        int wallStart = 1;
        int wallEnd = map.length - 1;
        for (int i = 1; i < map.length; i++) {
            map[wallStart][i] = '*';
        }
        for (int i = wallStart; i < wallEnd; i++) {
            map[i][wallEnd] = '*';
        }
        for (int i = wallEnd; i >= wallStart; i--) {
            map[wallEnd][i] = '*';
        }
        for (int i = wallEnd; i >= wallStart; i--) {
            map[i][wallStart] = '*';
        }

        for (int i = 3; i <= wallEnd - 2; i++) {
            for (int j = 3; j <= wallEnd - 2; j++) {
                if (i % 2 != 0 && j % 2 != 0)
                    map[i][j] = '*';
            }
        }

    }
}
