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
		int C = Integer.parseInt(st.nextToken());

		int curWidth = N;
		int curHeight = N;
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (y >= curWidth || x >= curHeight) {
				continue;
			}

			if (curWidth * x >= curHeight * y) {
				curHeight = x;
			} else {
				curWidth = y;
			}
		}

		System.out.println(curWidth * curHeight);

		// 가로 선택 가로: N 세로 y
		// 세로 선택 가로: x 세로 N

	}

}
