import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] house = new int[n][n];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][1] + house[i][0], dp[i - 1][2] + house[i][0]);
                    continue;
                }

                if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][0] + house[i][1], dp[i - 1][2] + house[i][1]);
                    continue;
                }

                if (j == 2) {
                    dp[i][j] = Math.min(dp[i - 1][0] + house[i][2], dp[i - 1][1] + house[i][2]);
                }
            }
        }

        int result = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));

        System.out.println(result);

    }
}
