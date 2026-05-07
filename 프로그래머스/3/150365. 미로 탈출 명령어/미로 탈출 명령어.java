import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    private static final int[] DR = {1, 0, 0, -1};
    private static final int[] DC = {0, -1, 1, 0};
    private static final String[] CMD = {"d", "l", "r", "u"};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int minDist = getDistance(x, y, r, c);

        if (minDist > k || (k - minDist) % 2 != 0) {
            return "impossible";
        }

        boolean[][][] visited = new boolean[n + 1][m + 1][k + 1];
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(x, y, 0, ""));
        visited[x][y][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.row == r && cur.col == c && cur.depth == k) {
                return cur.path;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nextRow = cur.row + DR[dir];
                int nextCol = cur.col + DC[dir];
                int nextDepth = cur.depth + 1;

                if (!isInRange(nextRow, nextCol, n, m)) {
                    continue;
                }

                if (nextDepth > k) {
                    continue;
                }

                if (visited[nextRow][nextCol][nextDepth]) {
                    continue;
                }

                int remain = k - nextDepth;
                int dist = getDistance(nextRow, nextCol, r, c);

                if (dist > remain || (remain - dist) % 2 != 0) {
                    continue;
                }

                visited[nextRow][nextCol][nextDepth] = true;
                queue.offer(new Node(
                        nextRow,
                        nextCol,
                        nextDepth,
                        cur.path + CMD[dir]
                ));
            }
        }

        return "impossible";
    }

    private int getDistance(int row1, int col1, int row2, int col2) {
        return Math.abs(row1 - row2) + Math.abs(col1 - col2);
    }

    private boolean isInRange(int row, int col, int n, int m) {
        return 1 <= row && row <= n && 1 <= col && col <= m;
    }

    private static class Node {
        int row;
        int col;
        int depth;
        String path;

        Node(int row, int col, int depth, String path) {
            this.row = row;
            this.col = col;
            this.depth = depth;
            this.path = path;
        }
    }
}