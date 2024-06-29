import java.util.*;
import java.io.*;

class Main {
	
	static Stack<Integer> stackInt = new Stack<>();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String strStack = st.nextToken();
			
			
			switch(strStack) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				stackInt.push(num);
				break;
				
			case "pop":
				if(stackInt.empty())
					System.out.println("-1");
				else
					System.out.println(stackInt.pop());
				break;
				
			case "top":
				if(stackInt.empty())
					System.out.println("-1");
				else
					System.out.println(stackInt.peek());
				break;
				
			case "size":
				System.out.println(stackInt.size());
				break;
				
			case "empty":
				if(stackInt.empty())
					System.out.println("1");
				else
					System.out.println("0");
				break;
			}
			
			
		}
	}
}
