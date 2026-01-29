import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {

    static int N;
    static List<Info> list = new ArrayList<>();
    static boolean[][] dragonMap;

    static class Info {
        int r;
        int c;
        int d;
        int g;

        public Info(int r, int c, int d, int g) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.g = g;
        }
    }


    public static void solve() throws IOException {
        input();
        drawDragon();
        int answer = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (isDragonSquare(i, j)) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean isDragonSquare(int r, int c) {
        return dragonMap[r][c] && dragonMap[r][c + 1] &&
                dragonMap[r + 1][c] && dragonMap[r + 1][c + 1];
    }

    private static void drawDragon() {
        int[] dirR = {0, -1, 0, 1};
        int[] dirC = {1, 0, -1, 0};

        Stack<Integer> stack = new Stack<>();
        for (Info info : list) {
            List<Integer> drawList = getDrawList(info);

            int tmpR = info.r;
            int tmpC = info.c;
            dragonMap[tmpR][tmpC] = true;
            for (int idx : drawList) {
                int nextR = tmpR + dirR[idx];
                int nextC = tmpC + dirC[idx];
                dragonMap[nextR][nextC] = true;
                tmpR = nextR;
                tmpC = nextC;
            }
        }
    }

    private static List<Integer> getDrawList(Info info) {
        Stack<Integer> stack = new Stack<>();
        stack.add(info.d);

        List<Integer> result = new ArrayList<>();
        result.add(info.d);
        for (int i = 0; i < info.g; i++) {
            while (!stack.isEmpty()) {
                int val = stack.pop();
                result.add(calcDis(val));
            }

            stack.addAll(result);
        }
        return result;
    }

    private static int calcDis(int val) {
        return (val + 1) % 4;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dragonMap = new boolean[102][102];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            list.add(new Info(r, c, d, g));
        }

    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
