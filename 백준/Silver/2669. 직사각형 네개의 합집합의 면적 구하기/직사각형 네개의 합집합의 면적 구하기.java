import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int result = 0;
		boolean[][] paper = new boolean[101][101];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					if (!paper[j][k]) {
						paper[j][k] = true;
						result++;
					}
				}
			}
		}
		System.out.println(result);

	}
}
