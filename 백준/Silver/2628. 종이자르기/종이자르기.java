import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int cutLine = Integer.parseInt(br.readLine());

		// 세로로 자름
		ArrayList<Integer> hCut = new ArrayList<Integer>();
		// 가로로 자름
		ArrayList<Integer> wCut = new ArrayList<Integer>();

		hCut.add(w);
		hCut.add(0);
		wCut.add(h);
		wCut.add(0);
		for (int i = 0; i < cutLine; i++) {
			st = new StringTokenizer(br.readLine());

			int state = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());

			if (state == 0) {
				wCut.add(pos);
			} else {
				hCut.add(pos);
			}
		}

		Collections.sort(hCut);
		Collections.sort(wCut);

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < wCut.size() - 1; i++) {
			int curH = wCut.get(i + 1) - wCut.get(i);
			for (int j = 0; j < hCut.size() - 1; j++) {
				int curW = hCut.get(j + 1) - hCut.get(j);
				int area = curH * curW;
				max = Math.max(area, max);
			}
		}

		System.out.println(max);

	}
}
