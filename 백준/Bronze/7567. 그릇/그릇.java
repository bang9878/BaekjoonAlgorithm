import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int sum = 10;
		char init = str.charAt(0);
		int sameCnt = 0;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != init) {
				sum += (sameCnt * 5);
				sum += 10;
				init = str.charAt(i);
				sameCnt = 0;
				continue;
			}
			sameCnt++;
		}
		
		sum += (sameCnt * 5);
		
		System.out.println(sum);
	}
}