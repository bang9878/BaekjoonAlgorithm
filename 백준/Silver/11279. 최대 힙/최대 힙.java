import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.*;
import java.lang.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int test_case = 0; test_case < T; test_case++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (maxHeap.isEmpty()) {
                    bw.write("0");
                    bw.write("\n");

                }
                else {
                    bw.write(String.valueOf(maxHeap.poll()));
                    bw.write("\n");
                }
                continue;
            }

            maxHeap.add(x);
        }
        bw.flush();
    }
}
