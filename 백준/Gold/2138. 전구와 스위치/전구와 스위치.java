import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

    static int N;
    static char[] now1; // 1번 스위치 킨 경우
    static char[] now2; // 1번 스위치 안 킨 경우
    static char[] expect;

    static int cnt1, cnt2;

    public static void solve() throws IOException {
        input();
        System.out.println(getAnswer());
    }

    private static int getAnswer() {

        for (int i = 1; i < N; i++) {
            if (now1[i - 1] != expect[i - 1]) {
                toggle(now1, i);
                cnt1++;
            }

            if (now2[i - 1] != expect[i - 1]) {
                toggle(now2, i);
                cnt2++;
            }
        }

        boolean isSame1 = Arrays.equals(now1, expect);
        boolean isSame2 = Arrays.equals(now2, expect);

        if (isSame1 && isSame2) {
            return Math.min(cnt1, cnt2);
        } else if (isSame1) {
            return cnt1;
        } else if (isSame2) {
            return cnt2;
        } else {
            return -1;
        }

    }
    private static void toggle(char[] arr, int i) {
        flip(arr, i - 1);
        flip(arr, i);
        flip(arr, i + 1);
    }
    private static void flip(char[] arr, int i) {
        if (i < 0 || i >= N) return;
        arr[i] = (arr[i] == '1') ? '0' : '1';
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        now1 = new char[N];
        now2 = new char[N];
        expect = new char[N];

        now1 = br.readLine().toCharArray();
        now2 = now1.clone();
        expect = br.readLine().toCharArray();

        now1[0] = (now1[0] == '1') ? '0' : '1';
        now1[1] = (now1[1] == '1') ? '0' : '1';
        cnt1++;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
