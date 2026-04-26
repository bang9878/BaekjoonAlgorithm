import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();
    }

    private static void solve() {
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (!dq.isEmpty() && dq.peekFirst() <= i - L) {
                dq.pollFirst();
            }

            sb.append(arr[dq.peekFirst()] + " ");
        }
        System.out.println(sb);
    }
}