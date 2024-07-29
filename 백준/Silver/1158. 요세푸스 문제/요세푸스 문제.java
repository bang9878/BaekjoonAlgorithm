import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.*;
import java.lang.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int print = 0;
        int i =1;
        int cnt = 0;

        int[] arr = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        System.out.print("<");

        while(true){

            if (print == N) {
                break;
            }
            if(i > N)i=1;

            if (!visited[i]) {
                cnt++;
            }

            if (cnt == K) {
                cnt=0;
                if(print+1 == N){
                    System.out.print(i);
                }else
                    System.out.print(i + ", ");
                print++;
                visited[i] = true;
            }

            i++;
        }

        System.out.print(">");


   }
}

