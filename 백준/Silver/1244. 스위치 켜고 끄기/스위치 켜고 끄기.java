import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[] mySwitch;

	public static void main(String[] args) throws IOException {

		// 스위치 개수
		N = Integer.parseInt(br.readLine());

		mySwitch = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			mySwitch[i] = Integer.parseInt(st.nextToken());
		}

		int personNum = Integer.parseInt(br.readLine());

		for (int i = 0; i < personNum; i++) {
			st = new StringTokenizer(br.readLine());
		

			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());

			// 1은 남학생 배수만큼
			if (gender == 1) {
				manChange(number);
			} else {
				girlChange(number);
			}
		}
		
		
		int cnt = 0;
		for(int j = 1; j <= N; j++) {
			if(cnt == 20) {
				cnt = 0;
				System.out.println();
			}
			System.out.print(mySwitch[j] + " ");
			cnt++;
		}
		System.out.println();
		
		
	}

	public static void manChange(int number) {
		for (int i = number; i <= N; i += number) {
			mySwitch[i] = (mySwitch[i] == 1) ? 0 : 1;
		}
	}

	public static void girlChange(int number) {

		for (int i = 1; i <= N; i++) {

			if (number - i < 1 || number + i > N || (mySwitch[number - i] != mySwitch[number + i])) {
				--i;
				
				if(i == 0) {
					mySwitch[number] = (mySwitch[number] == 1) ? 0 : 1;
					return;
				}
				
				for(int j = number - i; j <= number + i; j++) {
					mySwitch[j] = (mySwitch[j] == 1) ? 0 : 1;
				}
				 
				break;
			}
		}
	}
}
