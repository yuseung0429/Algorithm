package solved;

import java.util.Scanner;

public class Problem_2806 {
	public static int solution(int n)
	{
		boolean matrix[][] = new boolean[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				matrix[i][j] = true;
		return run(matrix, n, 0);
	}
	public static int run(boolean[][] matrix, int n, int row)
	{
		if(row == n) { return 1; }
		int count = 0;
		for(int i=0; i<n; i++)
			if(matrix[row][i])
				count += run(place(matrix,n,row,i), n, row+1);
		return count;
	}
	public static boolean[][] place(boolean[][] matrix, int n, int row, int col)
	{
		boolean[][] result = deepcopy(matrix, n);
		for(int i=0; i<n; i++)
		{
			result[row][i] = false;
			result[i][col] = false;
			if((row+i < n) && (col+i < n))
				result[row+i][col+i] = false;
			if((row-i >= 0) && (col-i >= 0))
				result[row-i][col-i] = false;
			if((row+i < n) && (col-i >= 0))
				result[row+i][col-i] = false;
			if((row-i >= 0) && (col+i < n))
				result[row-i][col+i] = false;
		}
		return result;
	}
	public static boolean[][] deepcopy(boolean[][] array, int n)
	{
		boolean[][] result = new boolean[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				result[i][j] = array[i][j];
		return result;	
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[] arr = new int[t];
		for(int i=0; i<t; i++)
			arr[i] = Integer.parseInt(in.nextLine());
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(arr[i]));
		in.close();
	}
}
