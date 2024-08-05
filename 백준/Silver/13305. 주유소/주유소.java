import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] distance = new long[N - 1];
        long[] price = new long[N];
        long min;

        long result = 0L;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long before = price[0];
        result = price[0] * distance[0];

        for (int i = 1; i < N - 1; i++) {
            before = Math.min(before, price[i]);
            result += before * distance[i];
        }

        System.out.println(result);


    }

}
