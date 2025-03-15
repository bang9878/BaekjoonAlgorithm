import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = N + 1;
		int result = 0;
		while (left <= right) {
			int mid = (left + right) / 2;

			boolean isPossible = true;
			int prev = 0;
			for (int i = 0; i < M; i++) {
				if(arr[i] - mid > prev) {
					isPossible = false;
					break;
				}
				prev = arr[i] + mid;
			}

			if(arr[M-1] + mid < N) isPossible = false;

			if (isPossible) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(result);
	}

}