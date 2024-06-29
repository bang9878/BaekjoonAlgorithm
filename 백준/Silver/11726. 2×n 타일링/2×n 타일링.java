import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[10001];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %=10007;
		}
		
		
		System.out.println(dp[n]);
	}
}
