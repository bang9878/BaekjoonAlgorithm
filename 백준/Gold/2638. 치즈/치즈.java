import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int time;
    static int[][] map;

    // 상하좌우
    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();

        System.out.println(time);
    }

    static void solution() {
        // 공기를 BFS를 담을 큐
        Queue<Pos> airQ = new LinkedList<>();
        Queue<Pos> delCheeseQ = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        airQ.add(new Pos(0, 0));
        visited[0][0] = true;

        while (true) {

            // 공기 BFS
            while (!airQ.isEmpty()) {
                Pos cur = airQ.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dirR[d];
                    int nc = cur.c + dirC[d];

                    if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        airQ.add(new Pos(nr, nc));
                    }
                }
            }

            int cnt = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 1) {
                        cnt++;
                        if (isDeleteCheese(i, j, visited)) {
                            delCheeseQ.add(new Pos(i, j));
                        }
                    }
                }
            }

            while(!delCheeseQ.isEmpty()) {
                Pos cur = delCheeseQ.poll();
                visited[cur.r][cur.c] = true;
                map[cur.r][cur.c] = 0;
                airQ.add(cur);
            }

            if (cnt == 0) {
                return;
            }

            ++time;
        }

    }

    static boolean isDeleteCheese(int r, int c, boolean[][] visited) {

        int cnt = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r + dirR[d];
            int nc = c + dirC[d];

            if (isIn(nr, nc) && map[nr][nc] == 0 && visited[nr][nc]) {
                cnt++;
            }
        }

        return cnt >= 2;
    }

    static boolean isIn(int r, int c) {
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