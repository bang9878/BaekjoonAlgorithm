import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int sum = 0;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}

		int result = 0;
		int left = 1;
		int right = sum;
		while (left <= right) {

			int mid = (left + right) / 2;

			int[] blueRay = new int[M];
			int mIdx = 0;
			int nIdx = 0;
			while (true) {

				if (mIdx >= M || nIdx >= N)
					break;

				if (blueRay[mIdx] + arr[nIdx] <= mid) {
					blueRay[mIdx] += arr[nIdx];
					nIdx++;
				} else {
					mIdx++;
				}

			}

			if (nIdx >= N) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}
		System.out.println(result);

	}

}