import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] dice = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int oneNum = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
            oneNum = Math.min(oneNum, dice[i]);
        }

        long result = 0L;
        if (N == 1) {
            Arrays.sort(dice);
            for (int i = 0; i < 5; i++) {
                result += dice[i];
            }
        } else {
            long threeCnt = 4;
            long twoCnt = 4L * (N - 2) + 4L * (N - 1);
            long oneCnt = (long) N * N * 5 - (threeCnt * 3 + twoCnt * 2);

            int threeNum =
                    Math.min(dice[0], dice[5]) + Math.min(dice[1], dice[4]) + Math.min(dice[2],
                            dice[3]);

            int twoNum = Integer.MAX_VALUE;
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    if (i + j != 5) {
                        twoNum = Math.min(twoNum, dice[i] + dice[j]);
                    }
                }
            }
            result = oneCnt * oneNum + twoCnt * twoNum + threeNum * threeCnt;
        }

        System.out.println(result);

    }
}
