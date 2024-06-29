
import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int sum = 0;
		
		if(N == 0) {
			System.out.println("0");
			return;
		}

		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		double tmpRange = (N*15.0) / 100.0;
		
		String strTmpRange = String.format("%.0f", tmpRange);
		int range = Integer.parseInt(strTmpRange);
		
		Arrays.sort(arr);
		
		for(int i = 0+range; i < arr.length-range; i++) {
			sum += arr[i];
		}
		
		double avg = sum / (double) (N-(2*range));
		String strAvg = String.format("%.0f", avg);
		int res = Integer.parseInt(strAvg);
		
		System.out.println(res);
	}
}
