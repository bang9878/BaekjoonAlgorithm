import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

    static final char OBSTACLE = 'O';
    static final int OBSTACLE_COUNT = 3;
    static int N;
    static char[][] map;
    static String answer = "NO";
    static List<Pos> list = new ArrayList<>();
    public static void solve() throws IOException {
        input();
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int r, int c) {
        if (depth == OBSTACLE_COUNT) {
            if (isPossible()) {
                answer = "YES";
            }
            return;
        }

        if (c == N) {
            r++;
            c = 0;
        }

        for (int i = r; i < N; i++) {
            for (int j = c; j < N; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = OBSTACLE;
                    dfs(depth + 1, r, c + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    private static boolean isPossible() {
        int[] dirR = {-1, 1, 0, 0};
        int[] dirC = {0, 0, -1, 1};

        for (Pos pos : list) {
            int findStudentCnt = 0;
            for (int d = 0; d < 4; d++) {
                for (int i = 1; i < N; i++) {
                    int nextR = pos.r + (dirR[d] * i);
                    int nextC = pos.c + (dirC[d] * i);

                    if(!isIn(nextR, nextC)) continue;

                    if (map[nextR][nextC] == 'O') {
                        break;
                    } else if (map[nextR][nextC] == 'S') {
                        findStudentCnt++;
                    }
                }
            }
            if (findStudentCnt > 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T') {
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

public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
