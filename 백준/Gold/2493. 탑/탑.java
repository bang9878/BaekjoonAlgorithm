import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    static int N;
    static int[] arr;

    static class Top {
        int idx;
        int val;

        public Top(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public static void solve() throws IOException {
        input();
        printAns();
    }

    private static void printAns() {
        PriorityQueue<Top> pq = new PriorityQueue<>(Comparator.comparing(t -> t.val));
        pq.add(new Top(N - 1, arr[N - 1]));

        int[] result = new int[N];
        for (int i = N - 2; i >= 0; i--) {
            while (!pq.isEmpty()) {
                Top top = pq.peek();

                if (arr[i] < top.val) {
                    break;
                }
                result[top.idx] = i + 1;
                pq.poll();
            }

            pq.add(new Top(i, arr[i]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
