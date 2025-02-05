import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] dis = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					dis[i][j] = 0;
				} else {
					dis[i][j] = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]);
				}
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(dis[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
		

		int min = Integer.MAX_VALUE;
		switch (K) {
		case 1:
			for (int i = 0; i < N; i++) {
				int max = 0;
				for (int j = 0; j < N; j++) {
					if (j == i)
						continue;
					max = Math.max(max, dis[i][j]);
				}
				min = Math.min(min, max);
			}

			break;
		case 2:
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int max = 0;
					for (int h = 0; h < N; h++) {
						if (h == i || h == j)
							continue;

						int distance = Math.min(dis[i][h], dis[j][h]);

						max = Math.max(max, distance);
					}
					min = Math.min(min, max);
				}
			}

			break;
		case 3:

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					for (int k = j + 1; k < N; k++) {
						int max = 0;
						for (int h = 0; h < N; h++) {
							if (h == i || h == j || h == k)
								continue;

							int distance = Math.min(dis[i][h], Math.min(dis[j][h], dis[k][h]));

							max = Math.max(max, distance);
						}
						min = Math.min(min, max);
					}
				}
			}
			break;
		}

		System.out.println(min);

	}

}
