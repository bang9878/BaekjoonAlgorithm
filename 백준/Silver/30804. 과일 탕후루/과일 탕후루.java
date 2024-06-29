import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	static int N;
	static int[] arr;
	static int[] num = new int[10];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int res = solve(0, 0, 0, 0, 0);

		System.out.println(res);
	}

	static int solve(int left, int right, int cnt, int kind, int max) {
		
		if (right >= N) {
			return max;
		}

		if (num[arr[right]] == 0) {
			kind++;
		}

		cnt++;
		num[arr[right]]++;
		
		if (kind > 2) {
			if (--num[arr[left]] == 0) {
				kind--;
			}
			cnt--;
			left++;
		}
		
		max = Math.max(max, cnt);

		return solve(left, right + 1, cnt, kind, max);
	}
}
