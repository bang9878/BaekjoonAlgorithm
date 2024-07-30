import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.*;
import java.lang.*;


class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        result = new int[M];

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i+1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}