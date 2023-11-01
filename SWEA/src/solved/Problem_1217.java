package solved;

import java.util.Scanner;

public class Problem_1217 {
	static int solution(int n, int m) {
		if(m == 0)
			return 1;
		return n * solution(n, m-1);
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int[] n = new int[10];
		int[] m = new int[10];
		for(int i=0; i<10; i++)
		{
			in.nextLine();
			String[] temp = in.nextLine().split(" ");
			n[i] = Integer.parseInt(temp[0]);
			m[i] = Integer.parseInt(temp[1]);
		}
		for(int i=0; i<10; i++)
			System.out.println("#"+(i+1)+" "+ solution(n[i], m[i]));
		in.close();
	}
}
