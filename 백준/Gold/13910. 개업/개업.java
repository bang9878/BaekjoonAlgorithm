import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] woks;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        woks = new int[M];
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 30001);
        dp[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            woks[i] = Integer.parseInt(st.nextToken());
            set.add(woks[i]);
            dp[woks[i]] = 1;
        }

        combination();
        int[] jjajang  = set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        for (int i = 0; i < jjajang.length; i++) {
            if (N >= jjajang[i]) {
                dp[jjajang[i]] = 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < jjajang.length; j++) {
                if (jjajang[j] <= i && dp[i - jjajang[j]] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - jjajang[j]] + 1);
                }
            }
        }
        if (dp[N] >= 30001) {
            System.out.println("-1");
        } else {
            System.out.println(dp[N]);
        }
    }

    private static void combination() {
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                set.add(woks[i] + woks[j]);
            }
        }
    }
}