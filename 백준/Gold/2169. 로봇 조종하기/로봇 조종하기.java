import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    static int R, C;
    static int[][] map;


    public static void solve() throws IOException {
        input();
        exploreMars();
    }

    private static void exploreMars() {
        int[] prev = new int[C];
        int[] LTR = new int[C]; // 왼 -> 오
        int[] RTL = new int[C]; // 오 -> 왼

        prev[0] = map[0][0];
        for (int c = 1; c < C; c++) {
            prev[c] = prev[c - 1] + map[0][c];
        }

        for (int r = 1; r < R; r++) {

            LTR[0] = prev[0] + map[r][0];
            for (int c = 1; c < C; c++) {
                LTR[c] = Math.max(LTR[c - 1], prev[c]) + map[r][c];
            }

            RTL[C - 1] = prev[C - 1] + map[r][C - 1];
            for (int c = C - 2; c >= 0; c--) {
                RTL[c] = Math.max(RTL[c + 1], prev[c]) + map[r][c];
            }

            for (int c = 0; c < C; c++) {
                prev[c] = Math.max(LTR[c], RTL[c]);
            }
        }
        System.out.println(prev[C - 1]);
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
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
