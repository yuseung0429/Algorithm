package solved;

import java.util.Scanner;

public class Problem_14178 {
	public static int solution(int n, int d)
	{
		return (n % (2*d+1) == 0) ? n/(2*d+1) : n/(2*d+1) + 1;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[] n = new int[t];
		int[] d = new int[t];
		for(int i=0; i<t; i++)
		{
			String[] temp = in.nextLine().split(" ");
			n[i] = Integer.parseInt(temp[0]);
			d[i] = Integer.parseInt(temp[1]);
		}
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(n[i], d[i]));
		in.close();
	}
}