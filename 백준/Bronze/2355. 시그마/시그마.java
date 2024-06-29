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
		long A,B;
		long n; //갯수 
		long sum;
		
		A = s.nextLong();
		B = s.nextLong();
		
		if(A>=B)
		n = A-B+1;

		else
		n = B-A+1;
	
		sum = (((A+B)*n)/2);
	
		System.out.println(sum);
		s.close();
	}
}