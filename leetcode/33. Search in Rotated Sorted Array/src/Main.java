import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] map;

    static void bfs() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, map[0][0]));

        while (!q.isEmpty()) {

        }
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        m = cin.nextInt();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = cin.nextInt();
            }
        }

        bfs();
    }
}

class Node {
    int x, y, hp;

    public Node() {
    }

    public Node(int x, int y, int hp) {
        this.x = x;
        this.y = y;
        this.hp = hp;
    }
}