import java.io.*;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.*;
import java.lang.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 1; i <= 10000000; i++) {
            sum+=i;

            if(sum>=num){
                if(i%2==0){
                    int pos = sum - num;
                    System.out.println((i-pos) + "/" + (pos+1));
                    return;
                }
                else {
                    int pos = sum - num;
                    System.out.println((pos + 1) + "/" + (i - pos));
                    return;
                }
            }
        }

   }
}

