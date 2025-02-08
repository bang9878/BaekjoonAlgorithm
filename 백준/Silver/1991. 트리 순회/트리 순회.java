import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static char[][] tree;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		tree = new char[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			char node = st.nextToken().charAt(0);
			char leftNode = st.nextToken().charAt(0);
			char rightNode = st.nextToken().charAt(0);

			tree[node - 'A'][0] = leftNode;
			tree[node - 'A'][1] = rightNode;
		}

		preDfs('A');
		sb.append('\n');
		inDfs('A');
		sb.append('\n');
		postDfs('A');

		System.out.println(sb);

	}

	public static void preDfs(int idx) {

		idx -= 'A';

		char cur = (char) (idx + 'A');
		if (cur == '.') {
			return;
		}

		sb.append((char) (idx + 'A'));
		preDfs(tree[idx][0]);
		preDfs(tree[idx][1]);

	}

	public static void inDfs(int idx) {

		idx -= 'A';

		char cur = (char) (idx + 'A');
		if (cur == '.') {
			return;
		}

		inDfs(tree[idx][0]);
		sb.append((char) (idx + 'A'));
		inDfs(tree[idx][1]);

	}

	public static void postDfs(int idx) {

		idx -= 'A';

		char cur = (char) (idx + 'A');
		if (cur == '.') {
			return;
		}

		postDfs(tree[idx][0]);
		postDfs(tree[idx][1]);
		sb.append((char) (idx + 'A'));

	}
}