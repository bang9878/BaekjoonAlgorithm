import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long S = Long.parseLong(br.readLine());
        Long num = 1L;
        Long cnt = 0L;

        while (true) {
            if (num >= S - num) {
                cnt++;
                break;
            }

            S-=num;
            num++;
            cnt++;
        }

        System.out.println(cnt);

    }
}

