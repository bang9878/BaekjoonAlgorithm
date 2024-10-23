import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int goodWordCnt = 0;

        String[] word = new String[N];

        for (int i = 0; i < N; i++) {
            word[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            stack.clear();
            for (int j = 0; j < word[i].length(); j++) {

                if (!stack.isEmpty() && stack.peek() == word[i].charAt(j)) {
                    stack.pop();
                    continue;
                }

                stack.add(word[i].charAt(j));
            }
            if (stack.isEmpty())
                goodWordCnt++;
        }

        System.out.println(goodWordCnt);

    }
}