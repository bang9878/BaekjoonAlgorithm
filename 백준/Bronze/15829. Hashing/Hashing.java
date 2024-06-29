import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		BigInteger sum = new BigInteger("0");
		
		
		String tmp = br.readLine();
		char[] arr = tmp.toCharArray();
		
		
		for(int i = 0; i < N; i++) {
			sum = sum.add(BigInteger.valueOf(arr[i] - 'a' + 1).multiply(BigInteger.valueOf(31).pow(i)));
		}
		
		
		
		System.out.println(sum.remainder(BigInteger.valueOf(1234567891)));
		
	}
}
