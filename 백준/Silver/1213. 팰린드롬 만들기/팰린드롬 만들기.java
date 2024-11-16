import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
//        char[] result = new char[str.length()];
        int[] alphabet = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            alphabet[c - 'A']++;
        }

        // 검증
        int oddCnt = 0;
        char remove = ' ';
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] % 2 != 0) {
                oddCnt++;
                remove = (char) (i + 'A');
            }
        }

        if ((oddCnt != 1 && str.length() % 2 != 0) || (oddCnt != 0 && str.length() % 2 == 0)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }


        String result1 = "";
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] == 0)
                continue;
            for (int j = 0; j < alphabet[i] / 2; j++) {
                 result1 = result1 + (char)(i + 'A');
            }
        }

        sb = new StringBuilder(result1);
        StringBuilder reverse = sb.reverse();
        String realResult;
        if (remove != ' ') {
            realResult = result1 + remove + reverse;
        } else {
            realResult = result1 + reverse;
        }

        System.out.println(realResult.trim());


    }
}