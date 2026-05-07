import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";

        boolean[][][] visited = new boolean[n + 1][m + 1][k  + 1];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y, 0, ""));
        visited[x][y][0] = true;

        // 하좌우상
        int[] dirR = {1, 0, 0, -1};
        int[] dirC = {0, -1, 1, 0};
        String[] cmdArr = {"d", "l", "r", "u"};
        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.r == r && cur.c == c && cur.cost == k) {
                return cur.cmd;
            }

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dirR[i];
                int nextC = cur.c + dirC[i];

                if(!isIn(nextR, nextC, n, m) || cur.cost + 1 > k || visited[nextR][nextC][cur.cost + 1]) continue;

                q.offer(new Node(nextR, nextC, cur.cost + 1, cur.cmd + cmdArr[i]));
                visited[nextR][nextC][cur.cost + 1] = true;
            }

        }

        return "impossible";
    }

    private boolean isIn(int r, int c, int R, int C) {
        return 0 < r && r <= R && 0 < c && c <= C;
    }
}

class Node {

    int r;
    int c;
    int cost;
    String cmd;

    public Node(int r, int c, int cost, String cmd) {
        this.r = r;
        this.c = c;
        this.cost = cost;
        this.cmd = cmd;
    }
}