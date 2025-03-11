import java.io.*;
import java.util.*;

public class Solution {

	// N = 크기, M = 비용
	static int N, M;
	static int[][] map;

	static ArrayList<Integer> houseList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			houseList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						houseList.add(i);
						houseList.add(j);
					}
				}
			}

			int max = Integer.MIN_VALUE;
			int maxD = N;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int d = 0; d <= maxD; d++) {
						int houseCnt = 0;
						// 범위 안에 집이 몇개 있는지 확인
						for (int h = 0; h <= houseList.size() - 2; h += 2) {
							int houseR = houseList.get(h);
							int houseC = houseList.get(h + 1);

							int curDis = Math.abs(i - houseR) + Math.abs(j - houseC);
							if (curDis <= d) {
								houseCnt++;
							}
						}
						int managerCost = (d + 1) * (d + 1) + d * d;
						int income = houseCnt * M;
						int result = income - managerCost;
						if (result >= 0) {
							max = Math.max(max, houseCnt);
						}
					}
				}
			}
			sb.append("#" + tc + " " + max).append('\n');
		}
		System.out.println(sb);
	}
}