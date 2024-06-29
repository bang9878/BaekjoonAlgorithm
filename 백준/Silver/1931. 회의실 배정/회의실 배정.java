import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int N;
	static int[][] meeting; 
	static int max = 0;
	static int cnt = 0;
	static int prevTime = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		N = Integer.parseInt(br.readLine());
		meeting = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) { // 두 번째 값이 같을 경우
					return o1[0]-o2[0];	// 첫번 째 기준으로 오름차순
				}
				return o1[1]-o2[1]; // 2번 째 기준으로 오름차순
			}	
		});
		
		
		for(int i = 0; i < N; i++) {
			if(prevTime <= meeting[i][0]) {
				prevTime = meeting[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);

		
	}	
}
