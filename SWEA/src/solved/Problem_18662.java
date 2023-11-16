package solved;

import java.util.Scanner;

public class Problem_18662 {
	public static double solution(int a, int b, int c)
	{
		return Math.min(Math.abs(((double)a-2*b+c)/2), Math.abs(2*b-a-c));
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[] a = new int[t];
		int[] b = new int[t];
		int[] c = new int[t];
		for(int i=0; i<t; i++)
		{
			String[] temp = in.nextLine().split(" ");
			a[i] = Integer.parseInt(temp[0]);
			b[i] = Integer.parseInt(temp[1]);
			c[i] = Integer.parseInt(temp[2]);
		}
		for(int i=0; i<t; i++)
			System.out.printf("#%d %.1f\n",(i+1),solution(a[i], b[i], c[i]));
		in.close();
	}
}
