import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static String methodStr;
    static String arrStr;

    static int[] arr;
    static char[] methodArr;

    public static void main(String[] args) throws NumberFormatException, IOException {

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            methodStr = br.readLine();
            n = Integer.parseInt(br.readLine());
            arrStr = br.readLine();

            inputInit();

            int start = 0;
            int end = n - 1;
            boolean isStart = true;
            boolean isEnd = false;
            int rCnt = 0;
            for (char command : methodArr) {
                if (command == 'R' && isStart) {
                    isStart = false;
                    isEnd = true;
                    rCnt++;
                    continue;
                }

                if (command == 'R' && isEnd) {
                    isStart = true;
                    isEnd = false;
                    rCnt++;
                    continue;
                }

                else if (command == 'D') {
                    n--;
                    if (isStart) {
                        start++;
                    }

                    else if (isEnd) {
                        end--;
                    }
                }
            }

            if (n < 0) {
                bw.write("error" + '\n');
                continue;
            }

            if (n == 0) {
                bw.write("[]" + '\n');
                continue;
            }

            if (rCnt % 2 == 0) {
                bw.write("[");
                for (int i = start; i <= end; i++) {
                    if (i == end) {
                        bw.write(String.valueOf(arr[i] + "]" + '\n'));
                        break;
                    }
                    bw.write(String.valueOf(arr[i]) + ",");
                }
            }

            else if (rCnt % 2 != 0) {
                bw.write("[");
                for (int i = end; i >= start; i--) {
                    if (i == start) {
                        bw.write(String.valueOf(arr[i] + "]" + '\n'));
                        break;
                    }
                    bw.write(String.valueOf(arr[i]) + ",");
                }
            }
        }
        bw.flush();
    }

    

    private static void inputInit() {
        st = new StringTokenizer(arrStr, ",[]");

        arr = new int[n];
        methodArr = new char[methodStr.length()];

        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < methodStr.length(); i++) {
            methodArr[i] = methodStr.charAt(i);
        }
    }
}
