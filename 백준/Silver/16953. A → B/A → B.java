import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int A;
    static int B;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        boolean wrong = false;


        while (true) {
            if (A == B) {
                break;
            }

            if (B < A || (B % 10 != 1 && B % 2 != 0)) {
                wrong = true;
                break;
            }

            if (B % 10 == 1) {
                B /= 10;
                cnt++;
                continue;
            }

            if (B % 2 == 0) {
                B /= 2;
                cnt++;
            }
        }

        if (wrong)
            System.out.println("-1");
        else
            System.out.println(cnt + 1);
    }
}

