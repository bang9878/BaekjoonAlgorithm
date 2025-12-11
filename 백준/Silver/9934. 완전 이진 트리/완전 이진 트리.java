import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            answer.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int total = (int) Math.pow(2, K) - 1;
        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, arr);

        for (int i = 0; i < K; i++) {
            for (int v : answer.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

    }

    private static void dfs(int depth, int[] arr) {
        if (depth == K) {
            return;
        }

        int parentIdx = arr.length / 2;
        int value = arr[parentIdx];
        answer.get(depth).add(value);

        int[] left = Arrays.copyOfRange(arr, 0, parentIdx);
        int[] right = Arrays.copyOfRange(arr, parentIdx, arr.length);

        dfs(depth + 1, left);
        dfs(depth + 1, right);

    }
}
