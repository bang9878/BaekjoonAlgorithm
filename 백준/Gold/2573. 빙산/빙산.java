import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Value {
        int r;
        int c;
        int minusNum;

        public Value(int r, int c, int minusNum) {
            this.r = r;
            this.c = c;
            this.minusNum = minusNum;
        }
    }

    static int R, C;
    static int[][] map;
    static List<Pos> candidates = new ArrayList<>();
    static Queue<Value> updateQ = new LinkedList<>();

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};
    static int iceCnt = 0;

    public static void solve() throws IOException {
        input();
        simulate();
    }

    private static void simulate() {
        int answer = 0;
        while (!isAnswer()) {

            if (iceCnt <= 0) {
                System.out.println("0");
                return;
            }

            for (Pos pos : candidates) {
                int cnt = 0;

                if (map[pos.r][pos.c] <= 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nextR = pos.r + dirR[d];
                    int nextC = pos.c + dirC[d];

                    if(!isIn(nextR, nextC)) continue;

                    if (map[nextR][nextC] == 0) {
                        cnt++;
                    }
                }
                updateQ.add(new Value(pos.r, pos.c, cnt));
            }

            while (!updateQ.isEmpty()) {
                Value value = updateQ.poll();
                int result = map[value.r][value.c] - value.minusNum;
                if (result <= 0) {
                    map[value.r][value.c] = 0;
                    iceCnt--;
                } else {
                    map[value.r][value.c] = result;
                }
            }

            answer++;
        }
        System.out.println(answer);
    }

    private static boolean isAnswer() {
        boolean[][] visited = new boolean[R][C];
        Queue<Pos> q = new LinkedList<>();

        int lump = 0;
        for (Pos pos : candidates) {

            if (visited[pos.r][pos.c] || map[pos.r][pos.c] <= 0) {
                continue;
            }

            q.add(new Pos(pos.r, pos.c));
            visited[pos.r][pos.c] = true;

            while (!q.isEmpty()) {
                Pos cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nextR = cur.r + dirR[d];
                    int nextC = cur.c + dirC[d];

                    if (isIn(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] > 0) {
                        visited[nextR][nextC] = true;
                        q.add(new Pos(nextR, nextC));
                    }
                }
            }
            lump++;
        }
        return lump >= 2;
    }

    private static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    iceCnt++;
                    candidates.add(new Pos(i, j));
                }
            }
        }

    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
