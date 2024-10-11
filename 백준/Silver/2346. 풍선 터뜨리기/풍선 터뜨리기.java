import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] ballonNum;
    static boolean[] isBoom;
    static int printCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        ballonNum = new int[N + 1];
        isBoom = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            ballonNum[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 1;
        while (true) {

            isBoom[idx] = true;
            sb.append(idx).append(" ");
            printCnt++;

            if(printCnt == N)break;

            if(ballonNum[idx] < 0) {
                idx = leftMove(idx, ballonNum[idx]);
            } else if (ballonNum[idx] > 0) {
                idx = rightMove(idx, ballonNum[idx]);
            }
        }
        System.out.println(sb);
    }

    private static int leftMove(int idx, int totalCnt) {
        int cnt = 0;
        while (cnt < Math.abs(totalCnt)) {
            idx--;
            if(idx < 1) {
                idx = N;
            }
            if(!isBoom[idx]) {
                cnt++;
            }
        }
        return idx;
    }

    private static int rightMove(int idx, int totalCnt) {
        int cnt = 0;
        while (cnt < totalCnt) {
            idx++;
            if(idx > N) {
                idx = 1;
            }
            if(!isBoom[idx]) {
                cnt++;
            }
        }
        return idx;
    }
}