import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;
            int target = arr[i];
            while (left < right) {
                int sum = arr[left] + arr[right];

                if (sum == target) {
                    if (left != i && right != i) {
                        answer++;
                        break;
                    } else if (left == i) {
                        left++;
                    } else {
                        right--;
                    }
                } else if (sum > target) {
                  right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(answer);
    }



    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }

}
