import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static String str1, str2;
    static int[][] dp;
    static List<Character> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        LCS();
        findStr(0, str1.length(), str2.length());
        Collections.reverse(answer);
        for (char c : answer) {
            System.out.print(c);
        }
    }

    static void findStr(int depth,int i, int j) {
        if (depth == dp[str1.length()][str2.length()]) {
            return;
        }

        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            answer.add(str1.charAt(i - 1));
            findStr(depth + 1, i - 1, j - 1);
        } else {
            if (dp[i - 1][j] > dp[i][j - 1]) {
                findStr(depth, i - 1, j);
            } else {
                findStr(depth, i, j - 1);
            }
        }

    }

    static void LCS() {
        dp = new int[str1.length() + 1][str2.length() + 1];

        dp[0][0] = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }



    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();
    }

}
