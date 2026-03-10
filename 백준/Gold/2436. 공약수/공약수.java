import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long gcd = Long.parseLong(st.nextToken());
        long lcm = Long.parseLong(st.nextToken());

        long m = lcm / gcd;

        long resultA = gcd;
        long resultB = lcm;
        for (long x = 1; x * x < m; x++) {
            if(m % x != 0) continue;

            long y = m / x;

            if (gcd(x, y) == 1) {
                resultA = gcd * x;
                resultB = gcd * y;
            }
        }
        System.out.println(resultA + " " + resultB);
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a;
            a = b;
            b = temp % a;
        }
        return a;
    }
}
