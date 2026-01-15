import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    static final int BLOCK = 1;
    static final int VIRUS = 2;
    static int N, M;
    static int[][] lab;
    static List<Pos> list = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    public static void run() throws IOException {
        input();
        dfs(0, 0,  new Pos[M]);
        if (answer == 1_00_000) {
            System.out.println("-1");
        } else {
            System.out.println(answer);
        }
    }

    private static void dfs(int depth, int start, Pos[] selected) {

        if (depth == M) {
            answer = Math.min(answer, bfs(selected));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            selected[depth] = list.get(i);
            dfs(depth + 1, i + 1, selected);
        }
    }

    private static int bfs(Pos[] selected) {
        // 상 하 좌 우
        int[] dirR = {-1, 1, 0, 0};
        int[] dirC = {0, 0, -1, 1};
        boolean[][] visited = new boolean[N][N];

        Queue<Virus> q = new LinkedList<>();
        for (Pos pos : selected) {
            visited[pos.r][pos.c] = true;
            q.add(new Virus(pos.r, pos.c, 0));
        }

        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Virus cur = q.poll();

            max = Math.max(max, cur.time);

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dirR[i];
                int nextC = cur.c + dirC[i];

                if (isIn(nextR, nextC) && lab[nextR][nextC] != BLOCK && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    q.add(new Virus(nextR, nextC, cur.time + 1));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lab[i][j] == BLOCK) continue;
                if (!visited[i][j]) {
                    return 1_00_000;
                }
            }
        }
        return max;
    }

    private static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == VIRUS) {
                    list.add(new Pos(i, j));
                }
            }
        }


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

class Virus {
    int r;
    int c;
    int time;

    public Virus(int r, int c, int time) {
        this.r = r;
        this.c = c;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution.run();
    }
}
