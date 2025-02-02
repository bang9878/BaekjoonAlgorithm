import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static StringTokenizer st;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int testCase = 1; testCase <= T; testCase++) {

			int N = Integer.parseInt(br.readLine());

			list = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int cmdCnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cmdCnt; i++) {
				char cmd = st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken());
				func(cmd, x);
			}

			sb.append("#" + testCase + " ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void func(char cmd, int x) {
		int y;

		switch (cmd) {
		case 'I':
			y = Integer.parseInt(st.nextToken());
			for (int i = 0, insertIdx = x; i < y; i++, insertIdx++) {
				list.add(insertIdx, Integer.parseInt(st.nextToken()));
			}
			break;

		case 'D':
			y = Integer.parseInt(st.nextToken());
			for (int i = 0; i < y; i++) {
				list.remove(x);
			}
			break;

		case 'A':
			for (int i = 0; i < x; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			break;
		}
	}
}
