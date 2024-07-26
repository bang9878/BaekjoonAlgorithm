import java.io.*;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.*;
import java.lang.*;


class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            BigInteger cnt = new BigInteger("0");

            BigInteger denominator = new BigInteger("1");
            BigInteger molecule = new BigInteger("1");

            if( N==1){
                System.out.println(M);
                continue;
            }

            for (int i = M; i > N; i--) {
                BigInteger iBig = BigInteger.valueOf(i);
                denominator = denominator.multiply(iBig);
            }

            for (int i = (M - N); i >= 1; i--) {
                BigInteger iBig = BigInteger.valueOf(i);
                molecule = molecule.multiply(iBig);
            }


            cnt = denominator.divide(molecule);

            System.out.println(cnt);
        }
    }
}

