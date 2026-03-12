import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class Main {

    static int N;
    static List<String> list = new ArrayList<>();
    static Map<Character, Integer> map = new HashMap<>();
    static int[] alpha = new int[26];

    static class Info implements Comparable<Info> {
        char alpha;
        int value;

        public Info(char alpha, int value) {
            this.alpha = alpha;
            this.value = value;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(o.value, this.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        priorityCalc();
        solve();
    }

    static void solve() {
        int sum = 0;
        for (String str : list) {
            int digit = 1;
            int result = 0;
            for (int i = str.length() - 1; i >= 0; i--) {
                char c = str.charAt(i);
                int value = map.get(c);
                result += digit * value;
                digit *= 10;
            }
            sum += result;
        }
        System.out.println(sum);
    }

    static void priorityCalc() {
        // 우선순위 계산
        for (String str : list) {
            int digit = 1;
            for (int i = str.length() - 1; i >= 0; i--) {
                char c = str.charAt(i);
                alpha[c - 'A'] += digit;
                digit *= 10;
            }
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            if(alpha[i] == 0) continue;

            pq.add(new Info((char) (i + 'A'), alpha[i]));
        }

        int val = 9;
        while (!pq.isEmpty()) {
            Info poll = pq.poll();
            map.put(poll.alpha, val--);
        }
    }
}
