import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		
		int intRes = Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c);
		
		int stringRes = Integer.parseInt(a+b) - Integer.parseInt(c);
		
		System.out.println(intRes);
		System.out.println(stringRes);
	}
}
