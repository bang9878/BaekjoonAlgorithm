import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] num = new int[1000001];
        ArrayList<Integer> decimal = new ArrayList<>();
        ArrayList<Integer> superDecimal = new ArrayList<>();

        for(int i = 0; i <= 1000000; i++){
            num[i] = i;
        }

        for (int i = 2; i <= 1000000; i++) {
            if (num[i] == 0)
                continue;
            for (int j = i * 2; j <= 1000000; j += i) {
                num[j] = 0;
            }
        }

        num[0] = 0;
        num[1] = 0;

        for (int i = 2; i <= 1000000; i++) {
            if (num[i] != 0)
                decimal.add(i);
        }

        for (int i = 0; i < decimal.size(); i++) {
            if (num[i + 1] != 0)
                superDecimal.add(decimal.get(i));
        }

        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(superDecimal.get(n - 1));

        }
    }
}
