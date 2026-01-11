import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Ball> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        int[] colorSum = new int[N + 1];
        int[] ans = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            pq.add(new Ball(i, color, size));
        }

        int total = 0;
        ArrayList<Ball> sameList = new ArrayList<>();
        Ball pre = pq.poll();
        sameList.add(pre);
        while (!pq.isEmpty()) {
            Ball cur = pq.poll();
            if (cur.size == pre.size) { // 같은 size면 반영하면 안됨
                sameList.add(cur);
                ans[cur.idx] = total - colorSum[cur.color];
            } else {
                // 다른 size면 이때 반영
                for (Ball b : sameList) {
                    total += b.size;
                    colorSum[b.color] += b.size;
                }
                sameList.clear();
                sameList.add(cur);
                ans[cur.idx] = total - colorSum[cur.color];
                pre = cur;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(ans[i]);
        }
    }
}

class Ball implements Comparable<Ball> {
    int idx;
    int color;
    int size;

    public Ball(int idx, int color, int size) {
        this.idx = idx;
        this.color = color;
        this.size = size;
    }

    @Override
    public int compareTo(Ball o) {
        return Integer.compare(this.size, o.size);
    }
}

