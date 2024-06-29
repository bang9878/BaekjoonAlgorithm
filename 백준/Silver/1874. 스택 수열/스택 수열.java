import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		int cnt = 0;

		// outpud 리스트에 1을 넣으면 + 출력 -1을 넣으면 - 출력
		ArrayList<Integer> output = new ArrayList<>();

		// 1~N까지 숫자를 사용했는가 확인하는 용도

		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int num : arr) {
			if (cnt < num) {
				for (int i = cnt+1; i <= num; i++) {
					s.add(i);
					cnt++;
					output.add(1);
				}
				s.pop();
				output.add(-1);
			}
			else {
				if(s.pop() != num) {
					System.out.println("NO");
					return;
				}
				output.add(-1);
			}
		}

		for (int i = 0; i < output.size(); i++) {
			if (output.get(i) == 1) {
				bw.write("+");
				bw.newLine();
			} else {
				bw.write("-");
				bw.newLine();
			}
		}

		bw.close();
		br.close();
	}

}
