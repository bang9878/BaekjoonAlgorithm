import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    static int N, K;
    static String num;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    public static void solve() {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int removeCnt = 0;
        for (int i = 0; i < N; i++) {
            char cur = num.charAt(i);

            while (!stack.isEmpty() && removeCnt < K && stack.peekLast() < cur) {
                stack.pollLast();
                removeCnt++;
            }
            stack.addLast(cur);
        }

        while (removeCnt < K) {
            stack.pollLast();
            removeCnt++;
        }

        for (char c : stack) {
            sb.append(c);
        }
        System.out.println(sb);
    }



    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = br.readLine();
    }

}
