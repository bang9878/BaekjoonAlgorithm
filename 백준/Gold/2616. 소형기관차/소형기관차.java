import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution {

    static int N, M; // N : 객차의 수, M : 소형 기관차 객차 수
    static int[] coach;
    static int[] rangeSumArr;
    public static void solve() throws IOException {
        input();
        calcRangeSum();
        System.out.println(dynamic());
    }

    private static int dynamic() {
        int len = N - M + 1;
        int[][] dp = new int[3][len];

        dp[0][0] = rangeSumArr[0];
        for (int i = 1; i < len; i++) {
            dp[0][i] = Math.max(rangeSumArr[i], dp[0][i - 1]);
        }

        for(int k = 1; k < 3; k ++) {
            for (int i = M * k; i < len; i++) {
                dp[k][i] = Math.max(dp[k - 1][i - M] + rangeSumArr[i], dp[k][i - 1]);
            }
        }
        return dp[2][len - 1];
    }

    private static void calcRangeSum() {
        rangeSumArr = new int[N - M + 1];

        for (int i = 0; i < M; i++) {
            rangeSumArr[0] += coach[i];
        }

        for (int i = 1; i <= N - M; i++) {
            rangeSumArr[i] = rangeSumArr[i - 1] - coach[i - 1] + coach[i + M - 1];
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        coach = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coach[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
    }

}


public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
