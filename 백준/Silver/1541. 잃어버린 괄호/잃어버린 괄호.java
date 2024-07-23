import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.lang.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        StringTokenizer sub = new StringTokenizer(expression, "-");

        int sum=Integer.MAX_VALUE;

        while (sub.hasMoreElements()) {
           int temp=0;

            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");

            while (add.hasMoreElements()) {
                temp += Integer.parseInt(add.nextToken());
            }

            if(sum == Integer.MAX_VALUE){
                sum = temp;
            } else{
                sum -= temp;
            }
        }

        System.out.println(sum);

    }
}

