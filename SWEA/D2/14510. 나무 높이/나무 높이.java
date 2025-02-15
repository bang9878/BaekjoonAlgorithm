import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());

			int max = 0;
			int[] trees = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, trees[i]);
			}

			int twoCnt = 0;
			int oneCnt = 0;

			for (int i = 0; i < N; i++) {
				int gap = max - trees[i];

				if (gap == 0)
					continue;

				twoCnt += gap / 2;
				oneCnt += gap % 2;
			}

			if (twoCnt > oneCnt) {
				while (Math.abs(twoCnt - oneCnt) > 1) {
					twoCnt--;
					oneCnt += 2;
				}
			}

			int result = 0;
			if (oneCnt > twoCnt) {
				result = oneCnt * 2 - 1;
			} else if(twoCnt > oneCnt) {
				result = twoCnt * 2;
			} else {
				result = oneCnt + twoCnt;
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}