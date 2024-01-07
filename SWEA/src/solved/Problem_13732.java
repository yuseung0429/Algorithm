package solved;

import java.util.Scanner;

public class Problem_13732 {
	public static String solution(char[][] matrix)
	{
		int min_row = matrix.length;
		int min_col = matrix.length;
		int max_row = -1;
		int max_col = -1;
		
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix.length; j++)
			{
				if(matrix[i][j]=='#')
				{
					if(min_row > i)	
						min_row = i;
					if(min_col > j)	
						min_col = j;
					if(max_row <= i)	
						max_row = i;
					if(max_col <= j)	
						max_col = j;
				}
			}
		if((max_col - min_col) != (max_row - min_row))
			return "no";
		for(int i=min_row; i<=max_row; i++)
			for(int j=min_col; j<=max_col; j++)
			{
				if(matrix[i][j] == '.')
					return "no";
			}
		return "yes";
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		char[][][] matrixs = new char[t][][];
		for(int i=0; i<t; i++)
		{
			int n = Integer.parseInt(in.nextLine());
			matrixs[i] = new char[n][n];
			for(int j=0; j<n; j++)
				matrixs[i][j] = in.nextLine().toCharArray();
		}
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(matrixs[i]));
		in.close();
	}
}