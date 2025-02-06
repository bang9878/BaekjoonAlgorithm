import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] baskets = new int[K + 1];
		int sum = 0;
		for (int i = 1; i < K; i++) {
			baskets[i] = i;
			sum += i;
		}

		baskets[K] = N - sum;
		if (baskets[K] < baskets[K - 1] + 1) {
			System.out.println("-1");
			return;
		}

		// 1 2 3 6

		int cnt = 0;
		int plusCnt = K - 1;
		while (true) {

			if (plusCnt == 0) {
//				System.out.println(baskets[K] + " " + baskets[1]);
				System.out.println(baskets[K] - baskets[1]);
				break;
			}

			if (baskets[K] - plusCnt <= baskets[K - 1] + 1) {
				plusCnt--;
				continue;
			}

			if (plusCnt == K - 1) {
				baskets[1]++;
				baskets[K] -= plusCnt;
				if(K != 2) {					
					baskets[K - 1]++;
				}
				continue;
			}

			baskets[K] -= plusCnt;
			baskets[K - 1]++;

		}

	}

}
