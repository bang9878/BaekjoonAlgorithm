import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());

		long[] arr = new long[(int) M];
		long max = Integer.MIN_VALUE;
		for (int i = 0; i < M; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(max, arr[i]);
		}

		long left = 1;
		long right = max;
		long result = 0;
		while (left <= right) {

			long mid = (left + right) / 2;

			long sum = 0;
			for (int i = 0; i < M; i++) {
				long mok = arr[i] / mid;
				long remain = (arr[i] % mid == 0) ? 0 : 1;
				sum += (mok + remain);
			}

			if (sum <= N) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(result);
	}
}