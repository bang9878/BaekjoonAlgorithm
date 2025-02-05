import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		System.setIn(new FileInputStream("Test5.txt"));
		// ---------여기에 코드를 작성하세요.---------------//

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] board = new int[19][19];
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		System.out.println();

		// 아래 오른쪽 우상향 우하향
		int[] dirR = { 1, 0, -1, 1 };
		int[] dirC = { 0, 1, 1, 1 };
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board[i][j] != 0) {
					int color = board[i][j];
					for (int d = 0; d < 4; d++) {

						int sameColorCnt = 0;
						int curR = i;
						int curC = j;

						// 없거나 다른색깔이거나 밖으로 나갈때까지 쭉 한방향으로 감
						while (true) {

							int nextR = curR + dirR[d];
							int nextC = curC + dirC[d];

							if (nextR < 0 || nextC < 0 || nextR >= 19 || nextC >= 19
									|| (color != board[nextR][nextC])) {

								break;
							}

							sameColorCnt++;

							curR = nextR;
							curC = nextC;
						}

						// 승리가 났는지 확인
						switch (d) {
						case 0:

							if ((i == 0 || (board[i - 1][j] != color)) && sameColorCnt == 4) {

								System.out.println(color);
								System.out.println((i + 1) + " " + (j + 1));
								return;
							}
							break;
						case 1:
							if ((j == 0 || (board[i][j - 1] != color)) && sameColorCnt == 4) {
								System.out.println(color);
								System.out.println((i + 1) + " " + (j + 1));
								return;
							}
							break;
						case 2:
							if (i + 1 <= 18 && (j == 0 || (board[i + 1][j - 1] != color)) && sameColorCnt == 4) {
								System.out.println(color);
								System.out.println((i + 1) + " " + (j + 1));
								return;
							}
							break;
						case 3:
							if ((i == 0 || j == 0 || (board[i - 1][j - 1] != color)) && sameColorCnt == 4) {
								System.out.println(color);
								System.out.println((i + 1) + " " + (j + 1));
								return;
							}
							break;
						}
					}
				}
			}
		}

		// 승리가 나지 않았다면 0
		System.out.println(0);

	}

}
