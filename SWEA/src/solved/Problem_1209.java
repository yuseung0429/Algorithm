package solved;

import java.util.Scanner;

public class Problem_1209 {
	static int solution(int[][] arr) {
		int xMax = rowSumsMax(arr);
		int yMax = colSumsMax(arr);
		int zMax = crossSumsMax(arr);
		return Math.max(xMax, Math.max(yMax, zMax));
	}
	
	static public int rowSumsMax(int arr[][])
	{
		int max = 0;
		for(int i=0; i<arr.length; i++)
		{
			int sum = 0;
			for(int j=0; j<arr[i].length; j++)
				sum += arr[i][j];
			if(sum > max)
				max = sum;
		}
		return max;
	}
	
	static public int colSumsMax(int arr[][])
	{
		int max = 0;
		for(int i=0; i<arr[0].length; i++)
		{
			int sum = 0;
			for(int j=0; j<arr.length; j++)
				sum += arr[j][i];
			if(sum > max)
				max = sum;
		}
		return max;
	}
	static public int crossSumsMax(int arr[][])
	{
		int max = 0;
		int sum = 0;
		for(int i=0; i<arr.length; i++)
			sum += arr[i][i];
		max = sum;
		
		sum = 0;
		for(int i=0; i<arr.length; i++)
			sum += arr[i][arr.length-1 - i];
		if(sum > max)
			max = sum;
		
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
		int arr[][][] = new int[10][100][100];
		for(int i=0; i<10; i++)
		{
			in.nextLine();
			for(int j=0; j<100; j++)	
				arr[i][j] = convertArrayStringToInteger(in.nextLine().split(" "));
		}
		for(int i=0; i<10; i++)
			System.out.println("#"+(i+1)+" "+ solution(arr[i]));
		in.close();
	}
}
