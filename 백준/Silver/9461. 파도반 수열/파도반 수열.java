import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


class Main {
    static BigInteger[] P = new BigInteger[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            init();

            if(N > 10) {
                for (int i = 11; i <= N; i++) {
                    P[i] = P[i - 1].add(P[i - 5]);
                }
            }
            bw.write(String.valueOf(P[N]) + '\n');
        }

        bw.flush();
   }

   static void init(){
        P[1] = BigInteger.valueOf(1);
        P[2] = BigInteger.valueOf(1);
        P[3] = BigInteger.valueOf(1);
        P[4] = BigInteger.valueOf(2);
        P[5] = BigInteger.valueOf(2);
        P[6] = BigInteger.valueOf(3);
        P[7] = BigInteger.valueOf(4);
        P[8] = BigInteger.valueOf(5);
        P[9] = BigInteger.valueOf(7);
        P[10] = BigInteger.valueOf(9);
   }
}

