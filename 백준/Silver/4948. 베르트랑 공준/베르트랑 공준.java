import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MAX_NUM = 246913;

        int[] decimal = new int[MAX_NUM];

        for (int i = 2; i < MAX_NUM; i++) {
            decimal[i] = 1;
        }

        for (int i = 2; i < MAX_NUM; i++) {
            if (decimal[i] == 0) {
                continue;
            }
            for (int j = i * 2; j < MAX_NUM; j += i) {
                decimal[j] = 0;
            }
        }

        int[] dp = new int[123457];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= 123456; i++) {
            int cnt1 = decimal[i];
            int cnt2 = decimal[i * 2];
            int cnt3 = decimal[i * 2 - 1];

            dp[i] = dp[i - 1] - cnt1 + cnt2 + cnt3;
        }

        while (true) {

            int num = Integer.parseInt(br.readLine());

            if (num == 0)
                break;

            bw.write(String.valueOf(dp[num]) + '\n');
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
