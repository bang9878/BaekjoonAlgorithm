import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] arr = new int[10];

        boolean isContainZero = false;

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                isContainZero = true;
            }
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));
            sum += num;
            arr[num]++;
        }

        int remainder = sum % 3;

        if (!isContainZero || remainder != 0) {
            System.out.println("-1");
            return;
        }

        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}