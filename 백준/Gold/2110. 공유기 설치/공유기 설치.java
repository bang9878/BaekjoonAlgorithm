import java.util.*;
import java.io.*;

public class Main {

	static int N, C;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int lo = 1;
		int hi = arr[N - 1] - arr[0] + 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2;

			if (canInstall(mid) < C) {
				hi = mid;
			}

			else {
				lo = mid + 1;
			}
		}
		System.out.println(lo - 1);
	}

	public static int canInstall(int distance) {

		int count = 1;
		int lastLocal = arr[0];

		for (int i = 1; i < N; i++) {
			int locate = arr[i];

			if (locate - lastLocal >= distance) {
				count++;
				lastLocal = locate;
			}
		}

		return count;
	}
}
