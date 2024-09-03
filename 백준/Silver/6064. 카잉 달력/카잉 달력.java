import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            int gcd = (M >= N) ? gCD(M, N) : gCD(N, M);
            int lim = M * N / gcd;

            int result = -1;
            for (int i = x; i <= lim; i += M) {
                if(i%N == y){
                    result = i + 1;
                    break;
                }
            }

            bw.write(String.valueOf(result) + '\n');

        }

        bw.flush();

    }

    private static int gCD(int m, int n) {
        return (n == 0) ? m : gCD(n, m % n);
    }
}
