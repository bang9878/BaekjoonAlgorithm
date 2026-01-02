import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static List<Integer> bundles = new ArrayList<>();
    static Map<Integer, Queue<Integer>> candidateMap = new HashMap<>(); // key : 마지막 원소의 높이, value idx 후보들

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());

            // 넣을 수 있는 곳이 있다면?
            if (candidateMap.containsKey(h + 1)) {
                Queue<Integer> queue = candidateMap.get(h + 1);
                if (queue.isEmpty()) {
                    bundles.add(h);
                    // 후보군 추가
                    if (candidateMap.containsKey(h)) {
                        candidateMap.get(h).add(bundles.size() - 1);
                    } else {
                        Queue<Integer> newQueue = new LinkedList<>();
                        newQueue.add(bundles.size() - 1);
                        candidateMap.put(h, newQueue);
                    }
                    continue;
                }
                int idx  = queue.poll();
                if (candidateMap.containsKey(h)) {
                    candidateMap.get(h).add(idx);
                } else {
                    Queue<Integer> newQueue = new LinkedList<>();
                    newQueue.add(idx);
                    candidateMap.put(h, newQueue);
                }
            } else { // 없으면 그냥 새로 넣으면 됨
                bundles.add(h);
                if (candidateMap.containsKey(h)) {
                    candidateMap.get(h)
                            .add(bundles.size() - 1);
                } else {
                    Queue<Integer> q = new LinkedList<>();
                    q.add(bundles.size() - 1);
                    candidateMap.put(h, q);
                }

            }
        }

        System.out.println(bundles.size());

    }
}
