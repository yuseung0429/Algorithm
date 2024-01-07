package solved;

import java.util.Scanner;

public class Problem_5642 {
	
	static public int solution(int[] arr) {
		int max_value = arr[0];
		int max = arr[0];
		int ret = arr[0];

		for(int i=1; i<arr.length; i++)
		{
			if(max_value < arr[i])
				max_value = arr[i];
			ret += arr[i];
			if(ret > max)
				max = ret;
			if(ret < 0)
				ret = 0;
		}
		if(max_value <= 0)
			return max_value;
		return max;
	}
	
	static int[] convertArrayStringToInteger(String[] arr)
	{
		int[] result = new int[arr.length];
		for(int i=0; i<arr.length; i++)
			result[i] = Integer.parseInt(arr[i]);
		return result;
	}
	
	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[][] arrs = new int[t][];
		for(int i=0; i<t; i++)
		{
			int n = Integer.parseInt(in.nextLine());
			arrs[i] = new int[n];
			arrs[i] = convertArrayStringToInteger(in.nextLine().split(" "));
		}
		for(int i=0; i<t; i++)
			System.out.println("#" + (i+1) + " " + solution(arrs[i]));
		in.close();
	}
}
