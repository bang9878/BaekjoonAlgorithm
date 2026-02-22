import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

    static List<String> list = new ArrayList<>();
    static int N;
    static int max = Integer.MIN_VALUE;
    static StringBuilder sb = new StringBuilder();
    static String prefix;

    static class Trie {
        Node root = new Node();

        public void insert(String str) {
            Node node = root;
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (node.child.containsKey(c)) {
                    cnt++;
                    sb.append(c);
                } else {
                    node.child.put(c, new Node());
                }
                node = node.child.get(c);
            }
            if (cnt >= max) {
                prefix = sb.toString();
                max = cnt;
            }
            sb.setLength(0);
        }
    }

    static class Node {
        Map<Character, Node> child;

        public Node() {
            child = new HashMap<>();
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        Trie trie = new Trie();
        for (int i = N - 1; i >= 0; i--) {
            trie.insert(list.get(i));
        }

        String[] answer = new String[2];
        int cnt = 0;
        for (String str : list) {
            if (str.startsWith(prefix)) {
                answer[cnt++] = str;
            }
            if (cnt == 2) {
                break;
            }
        }
        System.out.println(answer[0]);
        System.out.print(answer[1]);
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }
    }

}
