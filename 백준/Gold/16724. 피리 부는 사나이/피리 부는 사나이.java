import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] map;
    static boolean[][] visited;

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};
    static int answer = 0;
    static Map<String, Boolean> info = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j]) {
                    search(i, j);
                }
            }
        }

        System.out.println(answer);

    }

    static void search(int r, int c) {
        int curR = r;
        int curC =c;
        while (true) {

            if (info.containsKey(String.valueOf(curR) + curC)) {
                answer++;
                break;
            }

            if (visited[curR][curC]) {
                break;
            }

            info.put(String.valueOf(curR) + curC, true);
            visited[curR][curC] = true;
            int dirIdx = getDirIdx(map[curR][curC]);
            curR = curR + dirR[dirIdx];
            curC = curC + dirC[dirIdx];
        }
        info.clear();
    }

    static int getDirIdx(char cmd) {
        switch (cmd) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            default:
                return 3;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

    }
}