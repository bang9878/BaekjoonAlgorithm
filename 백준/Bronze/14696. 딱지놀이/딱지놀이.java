import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int round;
	static int[] aInfo;
	static int[] bInfo;

	public static void main(String[] args) throws IOException {
		round = Integer.parseInt(br.readLine());
		for (int i = 0; i < round; i++) {
			
			aInfo = new int[5];
			bInfo = new int[5];
			
			// A 어린이
			aInput();

			// B 어린이
			bInput();

			whoIsWin();
		}
		System.out.println(sb);

	}

	public static void whoIsWin() {
		for (int i = 4; i >= 1; i--) {
			if (aInfo[i] < bInfo[i]) {
				sb.append("B").append('\n');
				return;
			} else if (aInfo[i] > bInfo[i]) {
				sb.append("A").append('\n');
				return;
			}
		}
		sb.append("D").append('\n');
	}

	public static void aInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		int aCnt = Integer.parseInt(st.nextToken());
		for (int j = 0; j < aCnt; j++) {
			int shapeNum = Integer.parseInt(st.nextToken());
			aInfo[shapeNum]++;
		}
	}

	public static void bInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		int bCnt = Integer.parseInt(st.nextToken());
		for (int j = 0; j < bCnt; j++) {
			int shapeNum = Integer.parseInt(st.nextToken());
			bInfo[shapeNum]++;
		}
	}
}
