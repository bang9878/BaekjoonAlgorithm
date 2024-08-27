import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean arr[] = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            if (arr[i]) {
                continue;
            }
            int num = i;
            while (true) {
                String tmp = Integer.toString(num);
                int sum = 0;
                for (int j = 0; j < tmp.length(); j++) {
                    sum += (int) tmp.charAt(j) - '0';
                }
                num += sum;
                if (num > 10000)
                    break;
                arr[num] = true;
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if (!arr[i]) {
                bw.write(String.valueOf(i) + '\n');
            }
        }

        bw.flush();

    }
}
