import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	static int N;
	static int S;
	static int[] arr;
	static boolean[] visited;
	static int cnt = 0;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			combination(0,i);
		}
		
		System.out.println(cnt);
	}
	
	static void combination(int start, int r)
	{
		if(r==0) {
			addChk();
			return;
		}
		
		else {
			for(int i = start; i < N; i++) {
				visited[i]=true;
				combination(i+1,r-1);
				visited[i]=false;
			}
		}
	}
	
	static void addChk()
	{
		int sum = 0;
		for(int i = 0; i < N ; i++)
		{
			if(visited[i]) {
				sum+=arr[i];
			}
		}
		
		if(sum == S)
		{
			cnt++;
		}
	}
}
