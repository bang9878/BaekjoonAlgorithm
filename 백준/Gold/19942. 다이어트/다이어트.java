import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

    static class Nutrient {

        int p;  // 단백질
        int f;  // 지발
        int s;  // 탄수화물
        int v;  // 비타민
        int c;  // 비용

        public Nutrient(int p, int f, int s, int v, int c) {
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.c = c;
        }
    }

    static int N;
    static int mp, mf, ms, mv;
    static Nutrient[] nutrientArr;
    static List<Integer> curPick = new ArrayList<>();
    static List<Integer> bestPick = new ArrayList<>();
    static int bestCost = Integer.MAX_VALUE;


    public static void solve() throws IOException {
        input();
        dfs(0, 0, 0, 0, 0, 0);
        printAnswer();
    }

    private static void printAnswer() {
        if (bestCost == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(bestCost);
            for (int i : bestPick) {
                System.out.print(i + " ");
            }
        }
    }

    private static void dfs(int idx, int p, int f, int s, int v, int c) {
        // 현재 비용이 정답보다 큰 경우
        if (c > bestCost) return;

        // 최소 조건을 만족하는 경우
        if (mp <= p && mf <= f && ms <= s && mv <= v) {
            if (c < bestCost || isFasterThan(curPick, bestPick)) {
                bestCost = c;
                bestPick = new ArrayList<>(curPick);
            }
        }

        if (idx == N) return;

        // 선택
        curPick.add(idx + 1);
        Nutrient cur = nutrientArr[idx];
        dfs(idx + 1, p + cur.p, f + cur.f, s + cur.s, v + cur.v, c + cur.c);
        curPick.remove(curPick.size() - 1);

        // 비선택
        dfs(idx + 1, p, f, s, v, c);
    }

    private static boolean isFasterThan(List<Integer> curPick, List<Integer> bestPick) {
        if(bestPick.isEmpty()) return true;

        int len = Math.min(curPick.size(), bestPick.size());
        for (int i = 0; i < len; i++) {
            if(!curPick.get(i).equals(bestPick.get(i))) return curPick.get(i) < bestPick.get(i);
        }
        return curPick.size() < bestPick.size();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nutrientArr = new Nutrient[N];

        st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nutrientArr[i] = new Nutrient(p, f, s, v, c);
        }


    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
