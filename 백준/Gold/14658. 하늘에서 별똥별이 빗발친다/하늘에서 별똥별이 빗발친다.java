import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

    static int N, M, L, K;
    static List<Integer> xList = new ArrayList<>();
    static List<Integer> yList = new ArrayList<>();
    static List<Pos> total = new ArrayList<>();

    static class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int max = Integer.MIN_VALUE;
        for (int x : xList) {
            for (int y : yList) {
                max = Math.max(max, calc(x, y));
            }
        }
        System.out.println(K - max);
    }

    private static int calc(int startX, int startY) {
        int cnt = 0;
        for (Pos pos : total) {
            if (isIn(pos.x, pos.y, startX, startY)) {
                cnt++;
            }
        }
        return cnt;
    }

    private static boolean isIn(int x, int y, int startX, int startY) {
        return startX <= x && x <= startX + L
                && startY <= y && y <= startY + L;
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xList.add(x);
            yList.add(y);
            total.add(new Pos(x, y));
        }
    }

}
