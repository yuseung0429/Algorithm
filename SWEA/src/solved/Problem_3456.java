package solved;

import java.util.Scanner;

public class Problem_3456 {
	public static int solution(int[] lengths) {
		if(lengths[0] == lengths[1])
			return lengths[2];
		else if(lengths[1] == lengths[2])
			return lengths[0];
		else
			return lengths[1];
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[][] lengths = new int[t][3];
		for(int i=0; i<t; i++)
		{
			String[] temp = in.nextLine().split(" ");
			lengths[i][0] = Integer.parseInt(temp[0]);
			lengths[i][1] = Integer.parseInt(temp[1]);
			lengths[i][2] = Integer.parseInt(temp[2]);
		}
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(lengths[i]));
		in.close();
	}
}
