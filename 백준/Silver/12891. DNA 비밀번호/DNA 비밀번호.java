import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {

	static int checkMinimum;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int ans = 0;

		int S = parseInt(st.nextToken());
		int P = parseInt(st.nextToken());

		char[] pw = br.readLine().toCharArray();

		int[] minimums = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			minimums[i] = parseInt(st.nextToken());
			if (minimums[i] == 0) {
				checkMinimum++;
			}
		}

		int[] cur = new int[4];
		for (int i = 0; i < P; i++) {
			add(pw[i], cur, minimums);
		}

		if (checkMinimum == 4) {
			ans++;
		}

		for (int i = P; i < S; i++) {
			int j = i - P;
			add(pw[i], cur, minimums);
			remove(pw[j], cur, minimums);
			if (checkMinimum == 4) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}

	public static void add(char c, int[] cur, int[] minimums) {
		switch (c) {
		case 'A':
			cur[0]++;
			if (cur[0] == minimums[0]) {
				checkMinimum++;
			}
			break;

		case 'C':
			cur[1]++;
			if (cur[1] == minimums[1]) {
				checkMinimum++;
			}
			break;

		case 'G':
			cur[2]++;
			if (cur[2] == minimums[2]) {
				checkMinimum++;
			}
			break;

		case 'T':
			cur[3]++;
			if (cur[3] == minimums[3]) {
				checkMinimum++;
			}
			break;
		}
	}

	public static void remove(char c, int[] cur, int[] minimums) {
		switch (c) {
		case 'A':
			if (cur[0] == minimums[0]) 
				checkMinimum--;
			cur[0]--;
			break;

		case 'C':
			if (cur[1] == minimums[1]) {
				checkMinimum--;
			}
			cur[1]--;
			break;

		case 'G':
			if (cur[2] == minimums[2]) {
				checkMinimum--;
			}
			cur[2]--;
			break;

		case 'T':
			if (cur[3] == minimums[3]) {
				checkMinimum--;
			}
			cur[3]--;
			break;
		}
	}
}
