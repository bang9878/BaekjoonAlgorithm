import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    static final int LENGTH = 26;
    static int[] indegree = new int[26];
    static int[] times = new int[26];
    static int[] dp = new int[26];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void solution() throws IOException {
        input();
        topologicalSort();
    }

    private static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < LENGTH; i++) {
            if (indegree[i] == 0) {
                dp[i] = times[i];
                q.add(i);
            }
        }


        while (!q.isEmpty()) {
            Integer curJob = q.poll();

            int max = Integer.MIN_VALUE;
            for (Integer next : graph.get(curJob)) {
                indegree[next]--;
                dp[next] = Math.max(dp[next], dp[curJob] + times[next]);
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        int answer = 0;
        for (int result : dp) {
            answer = Math.max(result, answer);
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        for (int i = 0; i < LENGTH; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(indegree, -1);
        while ((line = br.readLine()) != null) {
            if(line.isEmpty())break;
            st = new StringTokenizer(line);

            char job = st.nextToken().charAt(0);
            times[job - 'A'] = Integer.parseInt(st.nextToken());

            if (st.hasMoreTokens()) {
                String from = st.nextToken();
                indegree[job - 'A'] = from.length();
                for (int i = 0; i < from.length(); i++) {
                    graph.get(from.charAt(i) - 'A')
                            .add(job - 'A');
                }
            } else {
                indegree[job - 'A'] = 0;
            }
        }
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solution();
    }
}
