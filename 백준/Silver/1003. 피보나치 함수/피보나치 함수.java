import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 0; test_case < T; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] f = new int[N+1][2];
			
			
			if(N == 0) {
				System.out.println("1" + " " + "0");
				continue;
			} 
			
			else if(N == 1) {
				System.out.println("0" + " " + "1");
				continue;
			}
			
			
		    f[0][0] = 1;
			f[0][1] = 0;
			f[1][0] = 0;
			f[1][1] = 1;
			
			
			
			for(int i = 2; i <= N; i++) {
				f[i][0] += f[i-2][0] + f[i-1][0];
				f[i][1] += f[i-2][1] + f[i-1][1];
			}
	
			System.out.println(f[N][0] + " " + f[N][1]);
		}
	}
}
