import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String tmp = br.readLine();

			if(tmp.equals("#")) return;
			
			
			String line = tmp.toLowerCase();
			int cnt = 0;

			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o'
						|| line.charAt(i) == 'u') {
					cnt++;
				}
			}
			
			System.out.println(cnt);
			
		}

	}

}
