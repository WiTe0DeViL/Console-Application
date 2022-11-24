package BombermanGame;

import java.util.HashMap;
import java.util.Scanner;

public class Placing {
    int n;
    Scanner scan = new Scanner(System.in);

    Placing(int n) {
        this.n = n;
        fill(index, n);
    }

    static HashMap<Character, Integer> index = new HashMap<>();

    private boolean isValid(String player, char[][] map) {
        return map[index.get(player.charAt(0))][index.get(player.charAt(1))] == ' ';
    }

    public void getPlayerPosition(char[][] map) {
        System.out.print("Enter player position : ");
        String player = scan.next();
        while (true) {
            if (isValid(player, map)) {
                map[index.get(player.charAt(0))][index.get(player.charAt(1))] = 'P';
                System.out.println("Player placed Successfully");
                break;
            } else {
                System.out.print("Enter a valid position for player : ");
                player = new Scanner(System.in).next();
            }
        }
    }

    private void fill(HashMap<Character, Integer> index, int n) {
        char val = 'A';
        for (int i = 1; i < n; i++) {
            index.put(val++, i);
        }
    }

    public void getKeyposition(char[][] map) {
        System.out.print("Enter Key position : ");
        String key = scan.next();
        while (true) {
            if (isValid(key, map)) {
                map[index.get(key.charAt(0))][index.get(key.charAt(1))] = 'K';
                System.out.println("Key placed Successfully");
                break;
            } else {
                System.out.print("Enter a valid position for key : ");
                key = new Scanner(System.in).next();
            }
        }
    }

    public void getVillains(char[][] map) {
        System.out.print("Enter villain position : ");
        String villain = scan.next();
        while (true) {
            if (isValid(villain, map)) {
                map[index.get(villain.charAt(0))][index.get(villain.charAt(1))] = 'V';
                System.out.println("Villain placed Successfully");
                break;
            } else {
                System.out.print("Enter a valid position for villain : ");
                villain = new Scanner(System.in).next();
            }
        }

    }

    public void getBricks(char[][] map) {
        System.out.print("Enter Bricks position : ");
        String Bricks = scan.next();
        while (true) {
            if (isValid(Bricks, map)) {
                map[index.get(Bricks.charAt(0))][index.get(Bricks.charAt(1))] = 'B';
                System.out.println("Brick placed Successfully");
                break;
            } else {
                System.out.print("Enter a valid position for Brick : ");
                Bricks = new Scanner(System.in).next();
            }
        }
    }
}
