package solved;

import java.util.Scanner;

public class Problem_12712 {
	
	public static int solution(int[][] matrix, int m)
	{
		int max = 0;
		int n= matrix.length;
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
			{
				int temp = posMax(matrix, m, i, j);
				if(max < temp)
					max = temp;
			}
		return max;
	}
	
	public static int posMax(int[][] matrix, int m, int i, int j)
	{
		int n= matrix.length;
		int psum=0;
		int msum=0;
		for(int k=1; k<m; k++)
		{
			if(i+k < n) psum += matrix[i+k][j];
			if(i-k >= 0) psum += matrix[i-k][j];
			if(j+k < n) psum += matrix[i][j+k];
			if(j-k >= 0) psum += matrix[i][j-k];
			
			if(i+k < n && j+k < n) msum += matrix[i+k][j+k];
			if(i-k >= 0 && j-k >= 0) msum += matrix[i-k][j-k];
			if(i-k >= 0 && j+k < n) msum += matrix[i-k][j+k];
			if(i+k < n && j-k >= 0) msum += matrix[i+k][j-k];
		}
		return Math.max(psum, msum) + matrix[i][j];
	}
	
	public static int[] convert(String[] strs)
	{
		int[] result = new int[strs.length];
		for(int i=0; i<strs.length; i++)
			result[i] = Integer.parseInt(strs[i]);
		return result;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[] m = new int[t];
		int[][][] matrixs = new int[t][][];
		for(int i=0; i<t; i++)
		{
			int[] temp = convert(in.nextLine().split(" "));
			m[i] = temp[1];
			matrixs[i] = new int[temp[0]][];
			for(int j=0; j<temp[0]; j++)
				matrixs[i][j] = convert(in.nextLine().split(" "));
		}
		for(int i=0; i<t; i++)
			System.out.println("#" + (i+1) + " " + solution(matrixs[i], m[i]));
		in.close();
	}
}
