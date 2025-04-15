import java.util.*;
import java.io.*;

public class Main {

	static class Belt {
		int idx; // belt의 번호
		int durability; // belt의 내구도
		boolean hasRobot;

		public Belt(int idx, int durability, boolean hasRobot) {
			this.idx = idx;
			this.durability = durability;
			this.hasRobot = hasRobot;
		}

		@Override
		public String toString() {
			return "Belt [idx=" + idx + ", durability=" + durability + ", hasRobot=" + hasRobot + "]";
		}

	}

	static int N, K;
	static Belt[] beltLine;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		beltLine = new Belt[2 * N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			int durability = Integer.parseInt(st.nextToken());
			beltLine[i] = new Belt(i, durability, false);
		}

		int success = 1;
		while (true) {
			// 벨트 회전 시키기
			beltRotation();
			// 로봇 이동
			moveRobot();
			// 로봇 올리기
			addRobot();
			if (!isPossible()) {
				System.out.println(success);
				return;
			}
			success++;
		}

	}

	private static boolean isPossible() {
		int cnt = 0;
		for (int i = 0; i < 2 * N; i++) {
			if (beltLine[i].durability == 0) {
				cnt++;
			}

		}
		if (cnt >= K) {
			return false;
		}

		return true;
	}

	private static void addRobot() {
		if (beltLine[0].durability >= 1) {
			beltLine[0].hasRobot = true;
			beltLine[0].durability--;
		}
	}

	private static void moveRobot() {
		// N-1이 내리는 위치
		for (int i = N - 1; i >= 0; i--) {
			// 다음 위치로 로봇을 옮길 수 있을 경우
			if (i == N - 1 && beltLine[i].hasRobot) {
				beltLine[i].hasRobot = false;
				continue;
			}
			if (beltLine[i].hasRobot && !beltLine[i + 1].hasRobot && beltLine[i + 1].durability >= 1) {
				beltLine[i].hasRobot = false;
				if (i + 1 == N - 1) { // 내리는 위치라면 내구도만 까이고 내리기
					beltLine[i + 1].durability--;
				} else { // 다음 위치에 로봇 올리기
					beltLine[i + 1].hasRobot = true;
					beltLine[i + 1].durability--;
				}
			}
		}
	}

	private static void beltRotation() {
		Belt last = beltLine[2 * N - 1];
		for (int i = 2 * N - 1; i >= 1; i--) {
			beltLine[i] = beltLine[i - 1];
		}
		beltLine[0] = last;
	}
}
