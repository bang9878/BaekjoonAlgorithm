import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String pw = br.readLine();
			
			int len = pw.length();
			
			if(len < 6 || len > 9) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
			
		}

	}
}
