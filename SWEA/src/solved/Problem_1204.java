package solved;

import java.util.Scanner;

public class Problem_1204 {
	static int solution(int[] arr) {
		int[] count = new int[101];
		for(int i=0; i<arr.length; i++)
			count[arr[i]]++;
		int max = 0;
		for(int j=1; j<count.length; j++)
		{
			if(count[max] <= count[j])
				max = j;
		}
		return max;
	}
	static int[] convertArrayStringToInteger(String[] arr)
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
		int arr[][] = new int[t][];
		for(int i=0; i<t; i++)
		{
			in.nextLine();
			int[] score = convertArrayStringToInteger(in.nextLine().split(" "));
			arr[i] = score;
		}
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+ solution(arr[i]));
		in.close();
	}
}
