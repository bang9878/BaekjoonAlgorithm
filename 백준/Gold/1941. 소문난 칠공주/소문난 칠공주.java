import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static char[][] classes = new char[5][5];
    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};
    static int ans = 0;
    static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        combination(0, 0, new boolean[5][5]);
        System.out.println(ans);
    }

    static void combination(int start, int depth, boolean[][] selected) {
        if (depth == 7) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (selected[i][j]) {
                        bfs(selected, i, j);
                        return;
                    }
                }
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;

            if (!selected[r][c]) {
                selected[r][c] = true;
                combination(i + 1, depth + 1, selected);
                selected[r][c] = false;
            }
        }
    }

    static void bfs(boolean[][] selected, int startR, int startC) {
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        q.add(new Pos(startR, startC));
        visited[startR][startC] = true;

        int dasomeCnt = 0;
        int doyeonCnt = 0;
        while (!q.isEmpty()) {
            Pos cur = q.poll();

            if (classes[cur.r][cur.c] == 'Y') {
                doyeonCnt++;
            } else {
                dasomeCnt++;
            }

            for (int d = 0; d < 4; d++) {
                int nextR = cur.r + dirR[d];
                int nextC = cur.c + dirC[d];

                if(!isIn(nextR, nextC) || visited[nextR][nextC] || !selected[nextR][nextC]) continue;

                visited[nextR][nextC] = true;
                q.add(new Pos(nextR, nextC));
            }
        }

        // 문제의 조건을 만족한 경우
        if (doyeonCnt + dasomeCnt == 7 && dasomeCnt >= 4) {
            ans++;
        }
    }

    static boolean isIn(int r, int c) {
        return 0 <= r && r < 5 && 0 <= c && c < 5;
    }


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                classes[i][j] = line.charAt(j);
            }
        }

    }

}