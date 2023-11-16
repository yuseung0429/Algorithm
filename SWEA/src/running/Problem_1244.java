package running;

import java.util.Scanner;

public class Problem_1244 {
	public static String solution(int[] number, int cnt_exch)
	{
		int n = (cnt_exch >= number.length) ? number.length-1 : cnt_exch;
		int i=0;
		while(i != n-1)
		{
			number = step(number, i+1);
			i++;
		}
		String result = "";
		for(int j : number)
			result += j;
		return result;
	}
	public static int[] step(int[] number, int start_pos)
	{
		int max_value = number[start_pos];
		int max_idx = start_pos;
		for(int i=0; i<number.length; i++)
		{
			
		}
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[][] number = new int[t][];
		int[] cnt_exch = new int[t];
		
		for(int i=0; i<t; i++)
		{
			String[] temp = in.nextLine().split(" ");
			String[] num_arr = temp[0].split("");
			number[i] = new int[num_arr.length];
			for(int j=0; j<t; j++)
				number[i][j] = Integer.parseInt(num_arr[j]);
			cnt_exch[i] = Integer.parseInt(temp[1]);
		}
		for(int i=0; i<t; i++)
			System.out.println("# " + (i+1) + " " + solution(number[i], cnt_exch[i]));
		
	}
}
