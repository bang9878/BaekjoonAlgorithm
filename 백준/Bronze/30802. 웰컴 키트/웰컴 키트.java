import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] size = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 6; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int pencilBudle = N / P;
		int penclie = N % P;
		int cloth = 0;
		for (int i = 0; i < 6; i++) {
			if(size[i] == 0)
				continue;
			if (size[i] <= T)
				cloth++;
			else if (size[i] > T) {
				if (size[i] % T == 0)
					cloth += size[i] / T;
				else
					cloth += size[i] / T + 1;
			}
		}
		
		System.out.println(cloth);
		System.out.print(pencilBudle + " " + penclie);

	}
}
