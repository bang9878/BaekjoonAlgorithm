import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println();
            return;
        }


        int num = 2;
        while (true) {
            if (N / num == 1 && N % num == 0) {
                bw.write(String.valueOf(num));
                bw.write('\n');
                break;
            }

            if (N % num == 0) {
                N = N / num;
                bw.write(String.valueOf(num));
                bw.write('\n');
                continue;
            }
            num++;

        }
        bw.flush();

    }
}