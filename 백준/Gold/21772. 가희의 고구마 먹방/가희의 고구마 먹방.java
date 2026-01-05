import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C, T, startR, startC;

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};
    static char[][] map;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        dfs(startR, startC, new boolean[R][C], 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int r, int c, boolean[][] isAte, int time, int cnt) {
        answer = Math.max(answer, cnt);
        if (time == T) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + dirR[i];
            int nextC = c + dirC[i];
            int nextT = time + 1;

            if(!isIn(nextR, nextC) || map[nextR][nextC] == '#') continue;

            if (map[nextR][nextC] == 'S' && !isAte[nextR][nextC]) {
                isAte[nextR][nextC] = true;
                dfs(nextR, nextC, isAte, nextT, cnt + 1);
                isAte[nextR][nextC] = false;
            } else {
                dfs(nextR, nextC, isAte, nextT, cnt);
            }
        }

    }

//    private static void bfs() {
//        int[] dirR = {0, -1, 1, 0, 0};
//        int[] dirC = {0, 0, 0, -1, 1};
//        Queue<Pos> q = new LinkedList<>();
//        q.add(new Pos(startR, startC, 0, 0));
//
//        int answer = Integer.MIN_VALUE;
//        while (!q.isEmpty()) {
//            Pos cur = q.poll();
//
//            answer = Math.max(answer, cur.cnt);
//
//            for (int i = 0; i < 5; i++) {
//                int nextR = cur.r + dirR[i];
//                int nextC = cur.c + dirC[i];
//                int nextT = cur.time + 1;
//
//                // 갈수 없는 경우
//                if(!isIn(nextR, nextC, nextT) || map[nextR][nextC] == '#') continue;
//
//                String key = nextR + String.valueOf(nextC);
//                if (map[nextR][nextC] == 'S' && !cur.ateMap.containsKey(key)) {
//                    cur.ateMap.put(key, true);
//                    q.add(new Pos(nextR, nextC, nextT, cur.cnt + 1));
//                } else {
//                    q.add(new Pos(nextR, nextC, nextT, cur.cnt));
//                }
//
//            }
//        }
//        System.out.println(answer);
//    }

    private static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                if (c == 'G') {
                    startR = i; startC = j;
                }
            }
        }
    }
}

class Pos {
    int r;
    int c;
    int time;
    int cnt;

    public Pos(int r, int c, int time, int cnt) {
        this.r = r;
        this.c = c;
        this.time = time;
        this.cnt = cnt;
    }

}
