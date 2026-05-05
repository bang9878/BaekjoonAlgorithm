import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

    final int OIL = 1;
    final int EMPTY = 0;

    int[] dirR = {-1, 1, 0, 0};
    int[] dirC = {0, 0, -1, 1};
    boolean[][] visited;
    int[][] groupArr;
    Map<Integer, Integer> groupValMap = new HashMap<>();
    int R;
    int C;

    public int solution(int[][] land) {
        int answer = 0;

        R = land.length;
        C = land[0].length;
        visited = new boolean[R][C];
        groupArr = new int[R][C];
        int groupId = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (land[i][j] == OIL && !visited[i][j]) {
                    bfs(i, j, land, ++groupId);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                if (groupArr[i][j] != 0) {
                    set.add(groupArr[i][j]);
                }
            }

            int sum = 0;
            for (int id : set) {
                sum += groupValMap.get(id);
            }
            set.clear();
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    private void bfs(int r, int c, int[][] land, int groupId) {
        Queue<Pos> q = new LinkedList<>();
        List<Pos> lump = new ArrayList<>();
        visited[r][c] = true;
        Pos now = new Pos(r, c);
        q.add(now);
        lump.add(now);
        int cnt = 1;
        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nextR = cur.r + dirR[d];
                int nextC = cur.c + dirC[d];

                if (!isIn(nextR, nextC) || visited[nextR][nextC] || land[nextR][nextC] == 0) continue;

                visited[nextR][nextC] = true;
                Pos pos = new Pos(nextR, nextC);
                q.offer(pos);
                lump.add(pos);
                cnt++;
            }
        }

        groupValMap.put(groupId, cnt);
        for (Pos pos : lump) {
            groupArr[pos.r][pos.c] = groupId;
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