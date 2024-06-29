import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		List<Integer> arr = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		int N = Integer.parseInt(br.readLine());
		int[] tmp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!map.containsKey(num)) {
				map.put(num, 0);
				arr.add(num);
			}
			tmp[i] = num;
		}

		Collections.sort(arr);

		for(int i = 0; i < map.size(); i++) {
			map.replace(arr.get(i), i);
		}
		
		for(int i = 0; i < N; i++) {
			bw.write(String.valueOf(map.get(tmp[i])) + " ");
		}
		
		bw.flush();
		
		

	}
}
