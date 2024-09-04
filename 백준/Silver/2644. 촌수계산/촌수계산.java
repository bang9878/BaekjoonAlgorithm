import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] family;
    static int n;
    static int m;
    static int start;
    static int end;
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // person count

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine()); // relation count

        family = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            family[parent][child] = true;
            family[child][parent] = true;
        }

        bfs(start);

        System.out.println(result);

    }

    private static void bfs(int start) {

        Queue<Node> q = new LinkedList<>();

        q.add(new Node(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.pos == end){
                result = cur.cnt;
                break;
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && family[cur.pos][i]) {
                    q.add(new Node(i, cur.cnt + 1));
                    visited[i] = true;
                }
            }
        }
    }
}

class Node {
    int pos;
    int cnt;

    public Node(int pos, int cnt) {
        this.pos = pos;
        this.cnt = cnt;
    }
}
