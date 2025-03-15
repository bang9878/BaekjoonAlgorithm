import java.io.*;
import java.util.*;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int prev = 3;
		int length = 3;
		int k = 0;

		while (length < N) {
			k++;
			prev = length;
			length = 2 * prev + (3 + k);
		}

		moo(length, k);

	}

	public static void moo(int length, int k) {

		int prev = (length - (3 + k)) / 2;
		if (k == 0) {
			if (N == 1) {
				System.out.println("m");
				return;
			} else {
				System.out.println("o");
				return;
			}
		}

		if (N <= prev) {
			moo(prev, k - 1);
		} else if (prev < N && N <= prev + 3 + k) {
			if (N == prev + 1) {
				System.out.println("m");
				return;
			} else {
				System.out.println("o");
				return;
			}
		} else {
			N -= (prev + (3 + k));
			moo(prev, k - 1);
		}

	}
}
