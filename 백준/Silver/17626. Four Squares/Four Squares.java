import java.io.*;
import java.util.*;
import java.lang.*;


class Main {
    static int n;
    static int[] arr;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[50001];

        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            double tmp = Math.sqrt(i);
            int isSquareRoot = (int) tmp;
            if(i == isSquareRoot*isSquareRoot) {
                arr[i] = 1;
                continue;
            }
            sol(i);
            arr[i] = min;
        }

        System.out.println(arr[n]);
    }

    static void sol(int idx) {
        min = 9999;
        for (int i = 1; i <= idx / 2; i++){
            int res = arr[i] + arr[idx - i];
            if(min > res){
                min = res;
            }
        }
    }
}

