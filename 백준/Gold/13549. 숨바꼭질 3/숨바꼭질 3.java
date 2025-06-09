import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int N, K;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        visited[N] = true;
        q.add(new Node(N, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            visited[cur.pos] = true;

            if (cur.pos == K) {
                ans = Math.min(ans, cur.time);
            }

            if (isIn(cur.pos * 2) && !visited[cur.pos * 2]) {
//                visited[cur.pos * 2] = true;
                q.add(new Node(cur.pos * 2, cur.time));
            }

            if (isIn(cur.pos + 1) && !visited[cur.pos + 1]) {
//                visited[cur.pos + 1] = true;
                q.add(new Node(cur.pos + 1, cur.time + 1));
            }

            if (isIn(cur.pos - 1) && !visited[cur.pos - 1]) {
//                visited[cur.pos - 1] = true;
                q.add(new Node(cur.pos - 1, cur.time + 1));
            }


        }

        System.out.println(ans);
    }

    static boolean isIn(int x) {
        return 0 <= x && x <= 100000;
    }
}

class Node {
    int pos;
    int time;

    public Node(int pos, int time) {
        this.pos = pos;
        this.time = time;
    }

//    @Override
//    public int compareTo(Node o) {
//        return Integer.compare(this.time, o.time);
//    }
}
