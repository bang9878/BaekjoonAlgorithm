import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            Trie trie = new Trie();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                list.add(str);
                trie.insert(str);
            }

            String result = "YES";
            for (String str : list) {
                if (!trie.isConsistent(str)) {
                    result = "NO";
                    break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}

class Node {
    Map<Character, Node> child;
    boolean endOfWord;

    public Node() {
        child = new HashMap<>();
        endOfWord = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String str) {
        Node node = this.root;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            node.child.putIfAbsent(c, new Node());
            node = node.child.get(c);
        }
        node.endOfWord = true;
    }

    public boolean isConsistent(String str) {
        Node node = this.root;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(node.child.containsKey(c)){
                node =  node.child.get(c);
            } else {
                return false;
            }
        }

        return node.endOfWord && node.child.isEmpty();
    }
}