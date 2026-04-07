import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static PriorityQueue<Lesson> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> result = new PriorityQueue<>();

    static class Lesson implements Comparable<Lesson> {
        int d;
        int p;

        public Lesson(int d, int p) {
            this.d = d;
            this.p = p;
        }

        @Override
        public int compareTo(Lesson o) {
            if (this.d == o.d) {
                return Integer.compare(o.p, this.p);
            }
            return Integer.compare(this.d, o.d);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void solve() {
        int sum = 0;
        while (!pq.isEmpty()) {
            Lesson cur = pq.poll();

            if (result.size() < cur.d) {
                result.add(cur.p);
            } else if (result.size() == cur.d) {
                if (result.peek() < cur.p) {
                    result.poll();
                    result.add(cur.p);
                }
            }
        }

        int answer = result.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(answer);
    }



    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            pq.add(new Lesson(d, p));
        }
    }
}