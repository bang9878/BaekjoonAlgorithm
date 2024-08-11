import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int n;
    static int[][] triangle;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        triangle = new int[500][500];
        int[][] dp = new int[500][500];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[0][0] + triangle[1][0];
        dp[1][1] = triangle[0][0] + triangle[1][1];

        for (int i = 2; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                    continue;
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
        }



        for (int i = 0; i < n; i++) {
            if (max < dp[n - 1][i])
                max = dp[n - 1][i];
        }

        System.out.println(max);
    }
}

