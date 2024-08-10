import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int N;
    static int r;
    static int c;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        double size = Math.pow(2, N);



        dfs(0, size, N, 0, 0);
        System.out.println(result);

    }

    static void dfs(double start, double size, int n, double row, double col) {

        if (row == r && col == c) {
            result = (int) start;
            return;
        }

        if (size == 2) {
            if (row == r && col == c) {
                result = (int) start;
                return;
            }
            if (row == r && col + 1 == c) {
                result = (int) start + 1;
                return;
            }
            if (row + 1 == r && col == c) {
                result = (int) start + 2;
                return;
            }
            if (row + 1 == r && col + 1 == c) {
                result = (int) start + 3;
                return;
            }

        }

        double newSize = size / 2;


        if (r < newSize + row && c < newSize + col) {
            dfs(start, newSize, n - 1, row, col);
        } else if (r < newSize + row && c >= newSize + col) {
            start = start + Math.pow(4, n - 1);
            dfs(start, newSize, n - 1, row, col + newSize);
        } else if (r >= newSize + row && c < newSize + col) {
            start = start + (Math.pow(4, n - 1) * 2);
            dfs(start, newSize, n - 1, row + newSize, col);
        } else if (r >= newSize + row && c >= newSize + col) {
            start = start + (Math.pow(4, n - 1) * 3);
            dfs(start, newSize, n - 1, row + newSize, col + newSize);
        }
    }
}
