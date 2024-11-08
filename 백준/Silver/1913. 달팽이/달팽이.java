import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int N;
    static int number;
    static int printNumber;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        number = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        printNumber = N*N;

        printSnail(0);

        int row=0;
        int col=0;
        arr[N/2][N/2] = 1;
        boolean isFind = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == number) {
                    row = i+1;
                    col = j+1;
                }
                sb.append(arr[i][j] + " ");
//                System.out.print(arr[i][j] + " ");
            }
            sb.append("\n");
//            System.out.println();
        }
        System.out.print(sb);
        System.out.println(row + " " + col);

    }

    private static void printSnail(int start) {
        if (start == N / 2) {
            return;
        }


        //아래
        for (int i = start; i < N - start; i++) {
            arr[i][start] = printNumber--;
        }

        //오른쪽
        for (int i = start + 1; i < N - start; i++) {
            arr[N-start-1][i] =  printNumber--;
        }

        //위에
        for (int i = N - start - 2; i >= start; i--) {
            arr[i][N-start-1] = printNumber--;
        }

        //왼쪽
        for (int i = N - start - 2; i >= start + 1; i--) {
            arr[start][i] = printNumber--;
        }

        printSnail(start+1);
    }
}