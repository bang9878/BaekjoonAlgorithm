import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        if (num == 0) {
            System.out.println("1");
            return;
        }

        int result = factorial(num);
        System.out.println(result);

    }

    private static int factorial(int num) {
        if (num == 1) {
            return 1;
        }

        return num * factorial(num - 1);

    }
}