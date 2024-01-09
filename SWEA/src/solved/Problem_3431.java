package solved;

import java.util.Scanner;

public class Problem_3431 {
	public static int solution(int l, int u, int x)
	{
		if(x > u)
			return -1;
		else if(x >= l)
			return 0;
		else
			return l-x;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[] l = new int[t];
		int[] u = new int[t];
		int[] x = new int[t];
		for(int i=0; i<t; i++) {
			String[] temp = in.nextLine().split(" ");
			l[i] = Integer.parseInt(temp[0]);
			u[i] = Integer.parseInt(temp[1]);
			x[i] = Integer.parseInt(temp[2]);
		}
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(l[i], u[i], x[i]));
		in.close();
	}
}
