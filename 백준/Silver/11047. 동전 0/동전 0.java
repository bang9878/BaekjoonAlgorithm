import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		int[] coin = new int[N];
		
		for(int i = 0; i < N; i++)
			coin[i] = Integer.parseInt(br.readLine());
		
		for(int i = N-1; i >= 0; i--) {
			if(K == 0)break;
			if(coin[i] <= K) {
				cnt += K/coin[i];
				K %= coin[i];
			}
		}
		
		System.out.println(cnt);
			
		
	}
}
