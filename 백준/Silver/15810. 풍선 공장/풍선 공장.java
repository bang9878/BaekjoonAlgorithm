import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] arr = new long[N];
		long min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, arr[i]);
		}

		long left = 1;
		long right = min * M;

		while (left + 1 < right) {
			long center = (left + right) / 2;
			long balloon = 0;

			for (int n = 0; n < N; n++) {
				balloon += (center / arr[n]);
			}

			if (balloon >= M) {
				right = center;
			} else {
				left = center;
			}
		}

		System.out.println(right);

	}
}