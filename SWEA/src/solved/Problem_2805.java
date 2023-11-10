package solved;

import java.util.Scanner;

public class Problem_2805 {
	public static int solution(int[][] matrix)
	{
		int n = matrix.length;
		int sum = 0;
		sum += rowSum(matrix, n/2, 0, n-1);
		for(int i=1; i<=n/2; i++)
		{
			sum += rowSum(matrix, n/2-i, i, n-1-i);
			sum += rowSum(matrix, n/2+i, i, n-1-i);
		}
		return sum;
	}
	public static int rowSum(int[][] matrix, int row, int start, int end)
	{
		int sum=0;
		for(;start<=end; start++)
			sum += matrix[row][start];
		return sum;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[][][] arr= new int[t][][];
		for(int i=0; i<t; i++)
		{
			int n = Integer.parseInt(in.nextLine());
			arr[i] = new int[n][];
			for(int j=0; j<n; j++)
			{
				String[] temp = in.nextLine().split("");
				for(int k=0; k<n; k++)
					arr[i][j][k] = Integer.parseInt(temp[k]);
			}
		}
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(arr[i]));
		in.close();
	}
}
