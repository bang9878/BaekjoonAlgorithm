import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        boolean[] isNotDecimal = new boolean[10001];

        for (int i = 2; i <= 10000; i++) {
            if (!isNotDecimal[i]) {
                for (int j = i + i; j <= 10000; j += i) {
                    isNotDecimal[j] = true;
                }
            }
        }

        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int small = 0;
            int big = 0;
            int[] result = new int[2];

            for (int i = 2; i <= n; i++) {
                if (!isNotDecimal[i] && !isNotDecimal[n - i]) {
                    if (n - i <= i) {
                        big = i;
                        small = n - i;
                    } else {
                        big = n - i;
                        small = i;
                    }
                    if (min > big - small) {
                        min = big - small;
                        result[0] = small;
                        result[1] = big;
                    }
                }
            }

            bw.write(String.valueOf(result[0]) + " " + String.valueOf(result[1]) + '\n');

        }
        bw.flush();

        br.close();
        bw.close();

    }
}
