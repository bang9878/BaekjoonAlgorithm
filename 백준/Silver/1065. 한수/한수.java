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

        int n = Integer.parseInt(br.readLine());

        if (n <= 99) {
            System.out.println(n);
            return;
        }

        int ans = 0;
        for (int i = 100; i <= n; i++) {
            boolean isHansu = true;
            String nStr = Integer.toString(i);
            int initNum = (int) (nStr.charAt(0) - nStr.charAt(1));
            for (int j = 1; j < nStr.length() - 1; j++) {
                if (initNum != (nStr.charAt(j) - nStr.charAt(j + 1))) {
                    isHansu = false;
                    break;
                }
            }
            if (isHansu) {
                ans++;
            }
        }

        System.out.println(ans + 99);
    }
}
