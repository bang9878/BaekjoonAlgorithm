import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
			
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(pQ.isEmpty() && num == 0) {
				bw.write("0" + '\n');
				continue;
			}
			
			else if(num == 0) {
				bw.write(String.valueOf(pQ.poll()) + '\n');
				continue;
			}
			
			pQ.add(num);
		}
		
		bw.flush();
		
		br.close();
		bw.close();

	}
}
