import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static String A, B;
    static int[][] LCS;
    static int max;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        findCommonStr(0, A.length(), B.length());
        System.out.print(sb.reverse().toString());
    }

    private static void findCommonStr(int depth, int i, int j) {
        if (depth == max) {
            return;
        }

        if (LCS[i][j] == LCS[i - 1][j]) {
            findCommonStr(depth, i - 1, j);
        } else if (LCS[i][j] == LCS[i][j - 1]) {
            findCommonStr(depth, i, j - 1);
        } else {
            sb.append(A.charAt(i - 1));
            findCommonStr(depth + 1, i - 1,j - 1);
        }
    }

    private static void solve() {
        for (int i = 0; i <= A.length(); i++) {
            for (int j = 0; j <= B.length(); j++) {
                if (i == 0 || j == 0) {
                    LCS[0][0] = 0;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else if (A.charAt(i - 1) != B.charAt(j - 1)) {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }
        max = LCS[A.length()][B.length()];
        System.out.println(max);
    }



    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine();
        B = br.readLine();
        LCS = new int[A.length() + 1][B.length() + 1];
    }

}
