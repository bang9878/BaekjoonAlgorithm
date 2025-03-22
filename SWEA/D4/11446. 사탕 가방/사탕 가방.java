import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			long M = Long.parseLong(st.nextToken());

			long[] arr = new long[N];
			long max = Long.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(st.nextToken());
				max = Math.max(max, arr[i]);
			}

			long left = 1L;
			long right = max;
			long res = 0L;
			while (left <= right) {

				long mid = (left + right) / 2;

				long sum = 0;
				for (int i = 0; i < N; i++) {
					sum += arr[i] / mid;
				}

				if (M <= sum) {
					res = mid;
					left = mid + 1;
				} else {
					right = mid - 1;
				}

			}

			sb.append("#" + tc + " " + res).append('\n');

		}
		System.out.println(sb);
	}
}