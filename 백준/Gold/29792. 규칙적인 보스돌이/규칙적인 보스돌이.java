import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] damage = new long[N];
        for (int i = 0; i < N; i++) {
            damage[i] = Long.parseLong(br.readLine());
        }

        long[] stamina = new long[K];
        long[] value = new long[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            stamina[i] = Long.parseLong(st.nextToken());
            value[i] = Long.parseLong(st.nextToken());
        }

        long[] dp; // 초당 최대메소 값어치

        long[] result = new long[N];
        for (int i = 0; i < N; i++) {
            long max = 0;
            dp = new long[901];
            for (int k = 0; k < K; k++) {
                long calc = ((stamina[k] + damage[i] - 1) / damage[i]);
                if (calc > 900)
                    continue;
                int time = (int) calc;
                for (int j = 900; j - time >= 0; j--) {
                    dp[j] = Math.max(dp[j], dp[j - time] + value[k]);
                    max = Math.max(max, dp[j]);
                }
            }
            result[i] = max;
        }
        Arrays.sort(result);
        long answer = 0;
        for (int i = N - 1; i >= N - M; i--) {
            answer += result[i];
        }
        System.out.println(answer);
    }
}
