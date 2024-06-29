import java.util.*;
import java.io.*;


class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> name = new HashMap<>(N);
		HashMap<String, String> num = new HashMap<>(N);
		
		for(int i = 1; i <= N; i++) {
			String input = br.readLine();
			name.put(Integer.toString(i), input);
			num.put(input, Integer.toString(i));
		}
		
		for(int i = 0; i < M; i++) {
			String problem = br.readLine();
			
			if(name.containsKey(problem)) {
				System.out.println(name.get(problem));
			}
			else if(num.containsKey(problem)) {
				System.out.println(num.get(problem));
			}
		}
		
	}
}
