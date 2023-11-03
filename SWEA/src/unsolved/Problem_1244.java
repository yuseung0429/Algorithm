package unsolved;

import java.util.Scanner;

public class Problem_1244 {
	static String solution(int[] arr, int cnt) {

		return null;
	}
	public static int[] convertStringArrayToIntArray(String[] arr)
	{
		int[] result = new int[arr.length];
		for(int i=0; i<arr.length; i++)
			result[i] = Integer.parseInt(arr[i]);
		return result;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[][] array = new int[t][];
		int[] cnt = new int[t];
		for(int i=0; i<t; i++)
		{
			String[] temp = in.nextLine().split(" ");
			array[i] = convertStringArrayToIntArray(temp[0].split(""));
			cnt[i] = Integer.parseInt(temp[1]);
		}
		for(int i=0; i<t; i++)
			System.out.println("#" + (i+1) + " " + solution(array[i], cnt[i]));
		in.close();
	}
}
