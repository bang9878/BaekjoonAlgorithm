import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] colorSum = new int[N + 1];
        int[] ans = new int[N + 1];

        // PQ 대신 리스트에 담기
        ArrayList<Ball> list = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            list.add(new Ball(i, color, size));
        }

        Collections.sort(list);

        int total = 0;
        ArrayList<Ball> sameList = new ArrayList<>();

        Ball pre = list.get(0);
        sameList.add(pre);
        ans[pre.idx] = total - colorSum[pre.color];

        for (int i = 1; i < N; i++) {
            Ball cur = list.get(i);

            if (cur.size == pre.size) { // 같은 size면 반영하면 안됨
                sameList.add(cur);
                ans[cur.idx] = total - colorSum[cur.color];
            } else {
                // 다른 size면 이때 이전 그룹 반영
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

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append('\n');
        }
        System.out.print(sb);
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
