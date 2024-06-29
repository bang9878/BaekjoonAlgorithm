import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> address = new HashMap<>(N);
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			address.put(st.nextToken(), st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			String problem = br.readLine();
			bw.write(address.get(problem) + "\n");
		}
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}
