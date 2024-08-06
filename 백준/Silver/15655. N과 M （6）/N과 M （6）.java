import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] result;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0,0);

        bw.flush();

    }

    private static void dfs(int start, int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(String.valueOf(result[i]));
                bw.write(" ");
            }
            bw.write('\n');
            return;
        }

        for (int i = start; i < N; i++) {
            result[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }

}
