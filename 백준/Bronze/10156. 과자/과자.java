/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int k;
		int n;
		int m;
		int change;
		int total;
		k = s.nextInt();
		n = s.nextInt();
		m = s.nextInt();
		total = k*n;
		if(total>m){
			change = total - m;
			System.out.println(change);
		}
		else
		System.out.println("0");
	
	}
}