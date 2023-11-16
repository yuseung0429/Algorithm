package running;

import java.util.Scanner;

public class Problem_1491 {
	public static int solution(int n, int a, int b)
	{
		int min = cal(n, a, b, 1, n);
		for(int r=2; r<n; r++)
		{
			int value = cal(n, a, b, r, n/r);
			if(min > value)
				min = value;
		}
		return min;
			
	}
	public static int cal(int n, int a, int b, int r, int c, int min)
	{
		if a*Math.abc(r-c) > min
		return a*Math.abs(r-c)+b*(n-r*c);
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[] n = new int[t];
		int[] a = new int[t];
		int[] b = new int[t];
		for(int i=0; i<t; i++)
		{
			String[] temp = in.nextLine().split(" ");
			n[i] = Integer.parseInt(temp[0]);
			a[i] = Integer.parseInt(temp[1]);
			b[i] = Integer.parseInt(temp[2]);
		}
		for(int i=0; i<t; i++)
			System.out.println("# "+(i+1) + " " + solution(n[i],a[i],b[i]));
		in.close();
		
	}
}
