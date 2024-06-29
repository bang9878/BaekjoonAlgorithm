
import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			 
			int cnt = 0;
			
			ArrayList<node> arr = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr.add(new node(i, Integer.parseInt(st.nextToken())));
			}
		
			if(N == 1) {
				System.out.println("1");
				continue;
			}
			
			while(true) {
				boolean print = true;
				for(int i=1; i<arr.size(); i++) {
					if(arr.get(0).mvp < arr.get(i).mvp) {
						int tmpIdx = arr.get(0).idx;
						int tmpMvp = arr.get(0).mvp;
						
						arr.remove(0);
						arr.add(new node(tmpIdx, tmpMvp));
						
						print = false;
						break;
					}
				}
				
				if(print) {
					if(arr.get(0).idx == idx) {
						System.out.println(cnt+1);
						break;
					}
					else {
						arr.remove(0);
						cnt++;
					}
				}
			}
			arr.clear();
			
		}
	}
}


class node{
	int idx;
	int mvp;
	
	public node(int idx, int mvp) {
		this.idx = idx;
		this.mvp = mvp;
	}
}
