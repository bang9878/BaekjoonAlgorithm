import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int paperCnt = Integer.parseInt(br.readLine());
		
		int result = 0;
		boolean[][] paper = new boolean[101][101];
		for (int i = 0; i < paperCnt; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					if(!paper[j][k]) {
						paper[j][k]  = true;
						result++;
					}
				}
			}
		}
		System.out.println(result);

	}
}
