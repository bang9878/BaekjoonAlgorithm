import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		
		int M = Integer.parseInt(br.readLine());
		int bit = 0;

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			
			switch(command) {
			case "add":
				int numAdd = Integer.parseInt(st.nextToken()) - 1;
				bit  = bit | (1<<numAdd);
				break;
				
			case "remove":
				int numRemove = Integer.parseInt(st.nextToken()) - 1;
				bit = bit & ~(1<<numRemove);
				break;
				
			case "check":
				int numCheck = Integer.parseInt(st.nextToken()) - 1;
				int tmp = bit & (1<<numCheck);
				sb.append(((tmp == 0) ? 0 : 1) + "\n");
				break;
				
			case "toggle":
				int numToggle = Integer.parseInt(st.nextToken()) - 1;
				bit = bit ^ (1<<numToggle);
				break;
				
			case "all":
				bit = (1<<21)-1;
				break;
				
			case "empty":
				bit = 0;
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
