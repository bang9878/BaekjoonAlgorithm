import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static int max = Integer.MIN_VALUE;
	static ArrayList<Integer> res = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int first = Integer.parseInt(br.readLine());

		for (int i = first / 2; i <= first; i++) {
			int cnt = 2;
			ArrayList<Integer> list = new ArrayList<>();
			list.add(first);
			list.add(i);
			solution(first, i, cnt, list);
		}

		System.out.println(max);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static void solution(int first, int sec, int cnt, ArrayList<Integer> list) {

		int f = first;
		int s = sec;
		int third = f - s;

		list.add(third);

		if (third < 0) {
			if (max < cnt) {
				max = cnt;
				list.remove(list.size() - 1);
				res = list;
			}
			return;
		}

		solution(s, third, cnt + 1, list);

	}
}
