import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] girls = new int[7];
		int[] men = new int[7];

		// 0은 여자 1은 남자
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());

			if (gender == 0) {
				girls[grade]++;
			} else {
				men[grade]++;
			}
		}

		int ans = 0;
		for (int i = 1; i < 7; i++) {
			if (girls[i] % k == 0) {
				ans += girls[i] / k;
			} else {
				ans += (girls[i] / k) + 1;
			}

			if (men[i] % k == 0) {
				ans += men[i] / k;
			} else {
				ans += (men[i] / k) + 1;
			}

		}
		
		System.out.println(ans);

	}
}
