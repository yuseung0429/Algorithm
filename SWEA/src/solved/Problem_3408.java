package solved;

import java.util.Scanner;

public class Problem_3408 {
	public static long[] solution(int n)
	{
		long[] result = new long[3];
		result[0] = (long)n*(n+1)/2;
		result[1] = 2*result[0]-n;
		result[2] = 2*result[0];
		return result;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int n[] = new int[t];
		for(int i=0; i<t; i++)
			n[i] = in.nextInt();
		for(int i=0; i<t; i++)
		{
			long[] temp = solution(n[i]);
			System.out.println("#"+(i+1)+" "+temp[0]+" "+temp[1]+" "+temp[2]);
		}
	}
}
