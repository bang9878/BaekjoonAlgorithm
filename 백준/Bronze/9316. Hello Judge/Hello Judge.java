import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    public static void solve() throws IOException {
        input();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("Hello World, Judge ")
                    .append(i + 1)
                    .append("!")
                    .append('\n');
        }
        System.out.println(sb);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
