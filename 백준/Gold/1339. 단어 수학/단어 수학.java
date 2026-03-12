import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    static int N;
    static List<String> list = new ArrayList<>();
    static int[] alpha = new int[26];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        solve();
    }


    static void solve() {
        // 우선순위 계산
        for (String str : list) {
            int digit = 1;
            for (int i = str.length() - 1; i >= 0; i--) {
                char c = str.charAt(i);
                alpha[c - 'A'] += digit;
                digit *= 10;
            }
        }

        Arrays.sort(alpha);
        int ans = 0;
        int value = 9;
        for (int i = 25; i >= 0; i--) {
            if(alpha[i] == 0) break;
            ans += (alpha[i] * value--);
        }
        System.out.println(ans);
    }
}
