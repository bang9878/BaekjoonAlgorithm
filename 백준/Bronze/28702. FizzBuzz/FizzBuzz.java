import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = new String[3];
		int num = 0, idx = 0;

		for (int i = 0; i < 3; i++) {
			arr[i] = br.readLine();
		}

		for (int i = 0; i < 3; i++) {

			if (arr[i].equals("FizzBuzz"))
				continue;
			else if (arr[i].equals("Fizz"))
				continue;
			else if (arr[i].equals("Buzz"))
				continue;

			else {
				num = Integer.parseInt(arr[i]);
				idx = i;
				break;
			}
		}

		int res = num + (3 - idx);

		if (res % 15 == 0)
			System.out.println("FizzBuzz");
		else if (res % 3 == 0)
			System.out.println("Fizz");
		else if (res % 5 == 0)
			System.out.println("Buzz");
		else
			System.out.println(res);
	}
}
