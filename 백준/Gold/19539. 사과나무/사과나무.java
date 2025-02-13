import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		int one = 0;
		int two = 0;
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			one += arr[i] % 2;
			two += arr[i] / 2;
			sum += arr[i];
		}
		
		if(sum % 3 != 0 || one > two) {
			System.out.println("NO");
		}  else {
			System.out.println("YES");
		}
		
	}
}
