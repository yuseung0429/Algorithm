package solved;

import java.util.Scanner;

public class Problem_16910 {
	public static int solution(int n)
	{
		int cnt_line = 4*n + 1;
		int cnt=0;
		for(int i=1; i<n; i++)
			for(int j=1; j<n; j++)
				if(i*i+j*j<=n*n)
					cnt++;
				else
					break;
		return cnt_line + cnt*4;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[] n = new int[t];
		for(int i=0; i<t; i++)
			n[i] = Integer.parseInt(in.nextLine());
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(n[i]));
		in.close();
	}
}
