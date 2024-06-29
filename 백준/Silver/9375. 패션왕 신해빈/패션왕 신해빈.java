import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {

			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			
			int res = 1;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				String name = st.nextToken();
				String type = st.nextToken();

				if (map.containsKey(type)) {
					int cnt = map.get(type);
					cnt+=1;
					map.replace(type, cnt);
				} else if (!map.containsKey(type)) {
					map.put(type, 1);
				}
			}
			
			
			for(int val: map.values()) {
				res *=(val+1);
			}
			res-=1;
			bw.write(String.valueOf(res) + '\n');

		}
		bw.flush();
	}
}
