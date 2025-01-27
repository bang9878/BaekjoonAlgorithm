import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

import org.w3c.dom.ls.LSOutput;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] bigDp = new int[N];
		int[] smallDp = new int[N];

		Arrays.fill(bigDp, 1);
		Arrays.fill(smallDp, 1);

		int max = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i] >= arr[i - 1]) {
				bigDp[i] = bigDp[i - 1] + 1;
			}

			if (arr[i - 1] >= arr[i]) {

				smallDp[i] = smallDp[i - 1] + 1;
			}
			max = Math.max(max, Math.max(bigDp[i], smallDp[i]));
		}

		System.out.println(max);

	}
}
