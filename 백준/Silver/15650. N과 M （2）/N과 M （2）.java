import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {
    static int N, M;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N+1];
        combination(1,M);
    }

    static void combination(int start, int r) {

        if(r==0){
            for(int i = 1; i <= N; i++){
                if(check[i])
                    System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= N; i++){
            check[i] = true;
            combination(i+1, r-1);
            check[i] = false;
        }
    }
}

