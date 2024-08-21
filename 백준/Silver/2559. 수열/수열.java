import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalDay = Integer.parseInt(st.nextToken());
        int continDay = Integer.parseInt(st.nextToken());

        int[] temper = new int[totalDay];
        int[] dp = new int[totalDay - continDay + 1];

        int sum = 0;
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalDay; i++) {
            temper[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < continDay; i++) {
            sum += temper[i];
        }

        dp[0] = sum;
        max = dp[0];

        for (int i = 1; i <= totalDay - continDay; i++) {
            dp[i] = dp[i - 1] - temper[i - 1] + temper[i - 1 + continDay];
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

        br.close();
    }
}
