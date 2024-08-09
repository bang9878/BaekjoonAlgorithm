import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int C = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < C; testCase++) {
            int total = 0;
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int[] score = new int[N];

            for (int i = 0; i < N; i++) {
                score[i] = Integer.parseInt(st.nextToken());
                total+=score[i];
            }

            int avg =  total / N;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if(avg < score[i]){
                    cnt++;
                }
            }

            double result = (double) cnt/N*100;
            System.out.printf("%.3f", result);
            System.out.print("%");
            System.out.println();
        }
    }
}
