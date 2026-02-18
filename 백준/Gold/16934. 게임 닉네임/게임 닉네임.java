import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {

    static int N;
    static Map<String, Integer> nameCntMap = new HashMap<>();
    static String[] nickname;

    static class Trie {

        Node root;

        public Trie() {
            root = new Node();
        }

        public String insert(String name) {
            Node node = root;
            int notChildCnt = 0;
            StringBuilder sb = new StringBuilder();
            String alias = "";
            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                sb.append(c);
                if (!node.child.containsKey(c)) {
                    node.child.put(c, new Node());
                    notChildCnt++;
                }

                if (notChildCnt == 1) {
                    alias = sb.toString();
                }
                node = node.child.get(c);
            }
            node.endOfWord = true;

            return alias;
        }
    }

    static class Node {

        HashMap<Character, Node> child;
        boolean endOfWord;

        public Node() {
            child = new HashMap<>();
        }

    }


    public void solve() throws IOException {
        input();
        System.out.print(extractAliasOfUser());
    }

    private StringBuilder extractAliasOfUser() {
        Trie trie = new Trie();
        StringBuilder sb = new StringBuilder();

        String result;
        for (int i = 0; i < N; i++) {
            result = trie.insert(nickname[i]);
            nameCntMap.merge(nickname[i], 1, Math::addExact);
            if (result.isEmpty()) {
                int cnt = nameCntMap.get(nickname[i]);
                result = (cnt >= 2) ? (nickname[i] + cnt) : nickname[i];
            }

            sb.append(result).append('\n');

        }
        return sb;
    }


    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nickname = new String[N];
        for (int i = 0; i < N; i++) {
            nickname[i] = br.readLine();
        }
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.solve();
    }
}
