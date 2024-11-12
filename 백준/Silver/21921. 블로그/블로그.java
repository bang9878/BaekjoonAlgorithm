import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main { ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] day = new int[N];
        int[] dp = new int[N - X + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            day[i] = Integer.parseInt(st.nextToken());
        }

        //초기화
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += day[i];
        }

        dp[0] = sum;

        int max = dp[0];
        int cnt = 1;
        for (int i = 1; i < N - X + 1; i++) {
            dp[i] = dp[i-1] + day[X+i-1] - day[i-1];
            if (max < dp[i]) {
                max = dp[i];
                cnt = 1;
            } else if(max == dp[i]) {
                cnt++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}