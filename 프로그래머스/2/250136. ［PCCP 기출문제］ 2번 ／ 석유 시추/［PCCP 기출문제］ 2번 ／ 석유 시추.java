import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {

    final int OIL = 1;
    final int EMPTY = 0;

    int[] dirR = {-1, 1, 0, 0};
    int[] dirC = {0, 0, -1, 1};
    boolean[][] visited;
    int[] totalSumColArr;
    int R;
    int C;

    public int solution(int[][] land) {
        R = land.length;
        C = land[0].length;
        visited = new boolean[R][C];
        totalSumColArr = new int[C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (land[i][j] == OIL && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < C; i++) {
            max = Math.max(max, totalSumColArr[i]);
        }

        return max;
    }

    private void bfs(int r, int c, int[][] land) {
        Queue<Pos> q = new ArrayDeque<>();
        visited[r][c] = true;
        q.add(new Pos(r, c));
        Set<Integer> visitedColIdx = new HashSet<>();
        int cnt = 1;
        while (!q.isEmpty()) {
            Pos cur = q.poll();

            visitedColIdx.add(cur.c);

            for (int d = 0; d < 4; d++) {
                int nextR = cur.r + dirR[d];
                int nextC = cur.c + dirC[d];

                if (!isIn(nextR, nextC) || visited[nextR][nextC] || land[nextR][nextC] == EMPTY) continue;

                visited[nextR][nextC] = true;
                Pos pos = new Pos(nextR, nextC);
                q.offer(pos);
                cnt++;
            }
        }

        for (int idx : visitedColIdx) {
            totalSumColArr[idx] += cnt;
        }

    }

    private boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}

class Pos {
    int r;
    int c;

    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }

}