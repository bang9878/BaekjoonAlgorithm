import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int tmp1 = 0, tmp2 = 0, tmp3 = 0;

		if (N == 1) {
			System.out.println("0");
			return;
		}

		else if (N == 2) {
			System.out.println("1");
			return;
		}

		else if (N == 1) {
			System.out.println("1");
			return;
		}

		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		for (int i = 4; i <= N; i++) {
			if (i % 2 != 0 && i % 3 != 0) {
				arr[i] = arr[i - 1] + 1;
				continue;
			}

			if (i % 2 == 0 && i % 3 != 0) {
				arr[i] = Math.min(arr[i / 2], arr[i - 1]) + 1;
			}

			else if (i % 3 == 0 && i % 2 != 0) {
				arr[i] = Math.min(arr[i / 3], arr[i - 1]) + 1;
			}

			else if (i % 6 == 0) {
				arr[i] = Math.min(Math.min(arr[i / 2],arr[i/3]),arr[i-1]) + 1;
			}
		}

		bw.write(String.valueOf(arr[N]));
		bw.flush();

		br.close();
		bw.close();

	}
}
