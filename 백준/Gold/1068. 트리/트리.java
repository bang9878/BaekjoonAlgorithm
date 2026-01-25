import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {

    static int N;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int answer;
    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        int root = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num != -1) {
                tree.get(num).add(i);
                continue;
            }
            root = i;
        }

        int removeNode = Integer.parseInt(br.readLine());

        if (removeNode == root) {
            System.out.println(0);
        } else {
            dfs(removeNode, root, new boolean[N]);
            System.out.println(answer);
        }
    }

    private static void dfs(int removeNode, int root, boolean[] visited) {
        visited[root] = true;
        int childNode = 0;
        for (int cur : tree.get(root)) {
            if (cur != removeNode && !visited[cur]) {
                childNode++;
                dfs(removeNode, cur, visited);
            }
        }

        if (childNode == 0) {
            answer++;
        }
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        Solution.solve();
    }
}
