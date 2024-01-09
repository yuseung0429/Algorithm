package solved;

import java.util.Scanner;

public class Problem_3314 {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[] avg = new int[t];
		for(int i=0; i<t; i++)
		{
			String[] temp = in.nextLine().split(" ");
			int sum = 0;
			for(int j=0; j<5; j++)
			{
				int score = Integer.parseInt(temp[j]);
				sum += (score<=40) ? 40 : score;
			}
			avg[i] = sum/5;
		}
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+avg[i]);
		in.close();
	}
}
