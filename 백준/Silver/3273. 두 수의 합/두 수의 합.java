import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int N;
    static int X;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> aMap = new HashMap<>();
        int[] a = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
             aMap.put(tmp, tmp);
             a[i] = tmp;
        }

        X = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (aMap.containsKey(X-a[i])) {
                cnt++;
            }
        }
        cnt/=2;
        System.out.println(cnt);
    }
}
