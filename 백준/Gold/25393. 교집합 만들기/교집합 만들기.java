import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {

    static int N, Q;
    static Map<Integer, Integer> leftMap = new HashMap<>();
    static Map<Integer, Integer> rightMap = new HashMap<>();
    static Map<String, Boolean> totalMap = new HashMap<>();

    public static void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            leftMap.merge(left, right, Math::max);
            rightMap.merge(right, left, Math::min);

            totalMap.put("L" + left + "R" + right, true);
        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            int answer = getAnswer(left, right);
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }

    private static int getAnswer(int left, int right) {
        if (totalMap.containsKey("L" + left + "R" + right)) {
            return 1;
        }

        Integer maxRight = leftMap.get(left);
        Integer minLeft = rightMap.get(right);

        if (maxRight != null && minLeft != null && maxRight >= right && minLeft <= left) {
            return 2;
        } else {
            return -1;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution.run();
    }
}
