import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long X;
	static long[] buggers, patties;
	static long count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		X = Long.parseLong(st.nextToken());

		buggers = new long[N + 1];
		patties = new long[N + 1];

		buggers[0] = 1;
		patties[0] = 1;
		for (int i = 1; i <= N; i++) {
			buggers[i] = 2* buggers[i - 1] + 3;
			patties[i] = 2 *patties[i - 1] + 1;
		}

		long result = countPatty(N, X);
		System.out.println(result);
	}

	public static long countPatty(int level, long x) {

		if (x == 0) return 0;
		if (level == 0) return 1;

		long half = buggers[level - 1];

		if(x == 1) return 0;
		if (x == half + 2) return patties[level - 1] + 1;
		else if(x <= half + 1) return countPatty(level - 1, x - 1);
		else return patties[level-1] + 1 + countPatty(level - 1,  x - half - 2);

	}

}