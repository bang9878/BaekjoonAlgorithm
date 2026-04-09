import com.sun.source.tree.Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    static int N;   // 석호촌에 살고 있는 사람의 수
    static int M;   // 기억하는 정보의 개수
    static Map<String, TreeSet<String>> childrenMap = new TreeMap<>();  // 부모 자식
    static Map<String, Integer> indegree = new HashMap<>(); // 진입 차수
    static Set<String> root = new TreeSet<>();  // 조상
    static Map<String, List<String>> graph = new HashMap<>();   // 조상 - 자식 관계


    public static void main(String[] args) throws IOException {
        input();
        topologicalSort();
        System.out.print(printAns());
    }

    static void topologicalSort() {
        // root 조상 찾기
        Queue<String> q = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                root.add(entry.getKey());
                q.add(entry.getKey());
            }
        }

        // 위상정렬로 탐색
        while (!q.isEmpty()) {
            String cur = q.poll();
            for (String next : graph.get(cur)) {
                indegree.computeIfPresent(next, (key, value) -> value - 1);
                if (indegree.get(next) == 0) {
                    q.add(next);
                    childrenMap.get(cur).add(next);
                }
            }
        }
    }

    static String printAns() {
        StringBuilder sb = new StringBuilder();

        sb.append(root.size()).append('\n');
        for (String ancestor : root) {
            sb.append(ancestor).append(" ");
        }
        sb.append('\n');

        for (Map.Entry<String, TreeSet<String>> entry : childrenMap.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue().size()).append(" ");
            for (String name : entry.getValue()) {
                sb.append(name).append(" ");
            }
            sb.append('\n');
        }

        return sb.toString();
    }


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String name = st.nextToken();
            childrenMap.put(name, new TreeSet<>());
            indegree.put(name, 0);
            graph.put(name, new ArrayList<>());
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String child = st.nextToken();
            String parent = st.nextToken();

            graph.get(parent).add(child);
            indegree.merge(child, 1, Integer::sum);
        }
    }
}