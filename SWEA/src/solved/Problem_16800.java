package solved;

import java.util.Scanner;

public class Problem_16800 {
	public static long solution(long n)
	{
		long n_sqrt = (long)Math.sqrt(n);
		long i = n_sqrt;
		for(; i>0; i--)
			if(n % i == 0)
				break;
		return i + n/i - 2;
	}
    
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		long[] n = new long[t];
		for(int i=0; i<t; i++)
			n[i] = Long.parseLong(in.nextLine());
		for(int i=0; i<t; i++)
			System.out.println("# "+(i+1)+" " + solution(n[i]));
		in.close();
	}
}
