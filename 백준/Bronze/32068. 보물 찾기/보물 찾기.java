import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 0; testcase < T; testcase++) {

			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			L -= S;
			R -= S;
			S -= S;

			int absL = Math.abs(L);
			int absR = Math.abs(R);

			if (absL == absR) {
				System.out.println(2 * absL);
			} else {
				if (absL < absR) {
					if (L < 0) {
						System.out.println((2 * absL) + 1);
					} else {
						System.out.println(2 * absL);
					}
				} else if (absL > absR) {
					if (R < 0) {
						System.out.println(2 * absR + 1);
					} else {
						System.out.println(2 * absR);
					}
				}
			}

		}

	}

}
