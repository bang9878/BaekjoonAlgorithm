import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

import org.w3c.dom.ls.LSOutput;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int k = Integer.parseInt(br.readLine());

		int[] lenArr = new int[6];

		int maxWidth = 0;
		int maxHeight = 0;

		int maxWidthIdx = 0;
		int maxHeightIdx = 0;
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());

			int direction = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			lenArr[i] = len;
			if (direction == 1 || direction == 2) {
				if (maxWidth < len) {
					maxWidth = len;
					maxWidthIdx = i;
				}
			} else {
				if (maxHeight < len) {
					maxHeight = len;
					maxHeightIdx = i;
				}
			}
		}

		int totalArea = maxWidth * maxHeight;
		int removeArea = lenArr[(maxWidthIdx + 3) % 6] * lenArr[(maxHeightIdx + 3) % 6];

		System.out.println((totalArea - removeArea) * k);

	}
}
