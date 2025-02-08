import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static ArrayList<Integer> nodeAParentList;
	static ArrayList<Integer> nodeBParentList;

	static Node[] nodes;

	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {

			nodeAParentList = new ArrayList<>();
			nodeBParentList = new ArrayList<>();

			st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());

			nodes = new Node[V + 1];
			for (int i = 0; i < V + 1; i++) {
				nodes[i] = new Node();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {

				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());

				nodes[parent].children.add(child);
				nodes[child].parentNode = parent;
			}

			findParent(nodeA, nodeAParentList);
			findParent(nodeB, nodeBParentList);

			for (int i = 0; i < V; i++) {
				if (!nodeAParentList.get(i).equals(nodeBParentList.get(i)))
					break;
				ans = nodeAParentList.get(i);
			}

			System.out.printf("#%d %d %d\n", testcase, ans, dfs(ans));

		}

	}

	public static int dfs(int idx) {
		int res = 1;
		for (int child : nodes[idx].children) {
			res += dfs(child);
		}
		return res;
	}

	public static void findParent(int node, ArrayList<Integer> parentList) {
		int parent = nodes[node].parentNode;
		if (parent != 0) {
			findParent(parent, parentList);
		}
		parentList.add(node);
	}

}

class Node {

	int parentNode;
	List<Integer> children;

	public Node() {
		this.parentNode = 0;
		children = new ArrayList<>();
	}

}