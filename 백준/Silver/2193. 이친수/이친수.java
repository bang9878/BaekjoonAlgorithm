import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.*;
import java.lang.*;


class Main {
    static int N;
    static long cnt = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        long prevPrev = 1L;
        long prev = 1L;

        for (int i = 3; i <= N; i++) {
            cnt = prev + prevPrev;
            prevPrev = prev;
            prev = cnt;
        }

        if (N == 1 || N == 2) {
            System.out.println("1");
            return;
        }

        System.out.println(cnt);
    }

}
