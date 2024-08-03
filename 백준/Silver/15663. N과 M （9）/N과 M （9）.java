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
    static int[] arr;
    static int[] result;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<String, String> map = new LinkedHashMap<>();
    static int sequence = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[10001];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            bw.write(key);
            bw.write("\n");
        }
        bw.flush();
    }

    private static void dfs(int depth) throws IOException {
        if (depth == M) {
            String tmp = "";
            for (int i = 0; i < M; i++) {
                tmp += Integer.toString(result[i]) + " ";
            }


            if (!map.containsKey(tmp)) {
                map.put(tmp, tmp);
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }

        }
    }
}

