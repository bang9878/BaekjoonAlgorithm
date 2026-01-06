import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);

            if (c == ')') {
                decompress();
            } else {
                stack.push(String.valueOf(c));
            }
        }

        System.out.println(getAnswer());

    }

    private static void decompress() {
        int total = 0;
        while (true) {
            String str = stack.pop();

            if (str.equals("(")) {
                int K = Integer.parseInt(stack.pop());
                total *= K;
                stack.push("count" + total);
                break;
            }

            if (str.startsWith("count")) {
                total += Integer.parseInt(str.substring(5));
            } else {
                total++;
            }


        }
    }

    private static int getAnswer() {
        int answer = 0;
        while (!stack.isEmpty()) {
            String item = stack.pop();

            if (item.startsWith("count")) {
                int count = Integer.parseInt(item.substring(5));
                answer += count;
            } else {
                answer++;
            }
        }
        return answer;
    }
}
