package solved;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem_1285 {
	public static String solution(ArrayList<Integer> array)
	{
		int min_distance = 100001;
		int cnt = 0;
		int temp = 0;
		for(int a : array)
		{
			temp = Math.abs(a);
			if(min_distance > temp)
			{
				min_distance = temp;
				cnt = 1;
			}
			else if (min_distance == temp)
			{
				min_distance = temp;
				cnt++;
			}
		}
		return "" + min_distance + " " + cnt;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		ArrayList<Integer>[] array = new ArrayList[t];
		for(int i=0; i<t; i++)
		{
			in.nextLine();
			String[] temp = in.nextLine().split(" ");
			array[i] = new ArrayList<Integer>();
			for(String c : temp)
				array[i].add(Integer.parseInt(c));
		}
		for(int i=0; i<t; i++)
			System.out.println("#" + (i+1) +" " + solution(array[i]));
	}
}
