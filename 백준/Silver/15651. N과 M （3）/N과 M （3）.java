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
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        result = new int[M];

        dfs(0);
        bw.flush();
    }

    private static void dfs(int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(String.valueOf(result[i]));
                bw.write(" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            result[depth] = i + 1;
            dfs(depth + 1);
        }
    }
}
