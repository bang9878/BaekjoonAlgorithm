import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int max = Integer.MIN_VALUE;
		int N = Integer.parseInt(br.readLine());

		int result = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == b && b == c && a == c) {
				result = 10000 + a * 1000;
			} else if (a != b && a != c && b != c) {

				int tmpMax = Math.max(a, Math.max(b, c));
				result = tmpMax * 100;
			} else {
				if (a == b) {
					result = 1000 + a * 100;
				} else if (b == c) {
					result = 1000 + b * 100;
				} else if (a == c) {
					result = 1000 + a * 100;
				}
			}
			
			max = Math.max(result, max);
		}
		
		System.out.println(max);

	}

}
