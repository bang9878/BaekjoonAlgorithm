import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dices;
	static int N;
	static int totalMax = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		dices = new int[N][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 6; i++) {
			choice(i, dices[0][i], 0, 0);
		}
		
		System.out.println(totalMax);
	}

	// 밑면 선택
	public static void choice(int downIdx, int num, int depth, int sum) {
		if (depth == N) {
			totalMax = Math.max(totalMax, sum);
			return;
		}

		int upIdx = 0;
		if (downIdx == 0) {
			upIdx = 5;
		} else if (downIdx == 1) {
			upIdx = 3;
		} else if (downIdx == 2) {
			upIdx = 4;
		} else if (downIdx == 3) {
			upIdx = 1;
		} else if (downIdx == 4) {
			upIdx = 2;
		} else if (downIdx == 5) {
			upIdx = 0;
		}

		int nextDiceDownIdx = 0;
		int max = -1;
		for (int i = 0; i < 6; i++) {
			if ((depth != N-1) && (dices[depth][upIdx] == dices[depth + 1][i])) {
				nextDiceDownIdx = i;
			}
			if (i != upIdx && i != downIdx) {
				max = Math.max(max, dices[depth][i]);
			}
		}

		choice(nextDiceDownIdx, dices[depth][upIdx], depth + 1, sum+=max);

	}
}
