import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N, K;
	static int len; // 한 변의 문자열 개수

	static char[] password;
	static HashSet<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			len = N / 4;
			set = new HashSet<String>();
			password = new char[N];
			password = br.readLine().toCharArray();

			int result = solution();
			sb.append("#" + tc + " " + result).append('\n');
		}
		System.out.print(sb);
	}

	public static int solution() {

		while (true) {

			// 비밀번호 생성하기 얻기
			if (getPassword() == 4) {
				break;
			}
			// 한칸씩 회전하기
			rotation();
		}

		// K번째 큰 수 찾기
		List<String> tmp = new ArrayList<>(set);
		List<Integer> list = new ArrayList<>();
		for (String s : tmp) {
			list.add(Integer.parseInt(s, 16));
		}

		Collections.sort(list, (o1, o2) -> o2 - o1);

		return list.get(K - 1);
	}

	public static void rotation() {
		char last = password[N - 1];
		for (int i = N - 1; i >= 1; i--) {
			password[i] = password[i - 1];
		}
		password[0] = last;

	}

	public static int getPassword() {
		StringBuilder sb = new StringBuilder();

		int idx = 0;
		String passStr[] = new String[4];
		for (int i = 0; i < N; i += len) {
			for (int j = i; j < i + len; j++) {
				sb.append(password[j]);
			}
			passStr[idx++] = sb.toString();
			sb.setLength(0);
		}

		// 비밀번호 결과 값에 저장하기
		int cnt = 0;
		for (String str : passStr) {
			if (set.contains(str)) {
				cnt++;
			} else {
				set.add(str);
			}
		}

		return cnt;
	}

}