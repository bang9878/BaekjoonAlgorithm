import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 3, 2);

        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void hanoi(int N, int start, int to, int via) throws IOException {
        if (N == 1) {
            printMove(start, to);

            return;
        } else {
            hanoi(N - 1, start, via, to);
            printMove(start, to);
            hanoi(N - 1, via, to, start);
        }

    }

    private static void printMove(int start, int to) throws IOException {
        sb.append(String.valueOf(start)).append(" ").append(String.valueOf(to)).append('\n');
        cnt++;
    }
}
