import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int row;
    static int col;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int depth = Math.min(row, col);

        findSquare(depth);

    }

    private static void findSquare(int depth) {
        if(depth == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i <= row - depth; i++) {
            for (int j = 0; j <= col - depth; j++) {
                if (isSame(i,j,depth)) {
                    System.out.println(depth*depth);
                    return;
                }
            }
        }

        findSquare(depth-1);
    }

    private static boolean isSame(int i, int j, int depth) {
        if((arr[i][j] == arr[i+depth-1][j]) && (arr[i][j] == arr[i][j+depth-1])
        && (arr[i][j] == arr[i+depth-1][j+depth-1])){
            return true;
        }
        return false;
    }
}