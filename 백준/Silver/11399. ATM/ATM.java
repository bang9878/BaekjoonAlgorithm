import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		
		int[] P = new int[N];
		int[] time = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(P);
		
		for(int i = 0; i < N; i++) {
			sum += P[i];
			time[i] = sum;
		}
		
		sum = 0;
		
		for(int i = 0; i < N; i++) {
			sum += time[i];
		}
		
		System.out.println(sum);
		
		
	}
}
