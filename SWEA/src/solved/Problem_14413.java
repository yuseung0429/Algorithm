package solved;

import java.util.Scanner;

public class Problem_14413 {
	
	public static String solution(char[][] matrix, int row, int col)
	{
		int nrow = matrix.length;
		int ncol = matrix[0].length;
		for(int i=row; i<nrow; i++)
			for(int j=col; j<ncol; j++)
				if(matrix[i][j]=='?')
				{
					matrix[i][j] = '#';
					boolean r1 = check(matrix, i, j);
					matrix[i][j] = '.';
					boolean r2 = check(matrix, i, j);
					if(r1==false && r2==false)
						return "impossible";
					else if(r1==true && r2==true)
					{
						char[][] c1_matrix = deepcopy(matrix);
						char[][] c2_matrix = deepcopy(matrix);
						c1_matrix[i][j] = '#';
						c2_matrix[i][j] = '.';
						if(solution(c1_matrix, i, j).equals("possible") || solution(c2_matrix, i, j).equals("possible"))
							return "possible";
						return "impossible";
					}
					else
						matrix[i][j] = (r1) ? '#' : '.';
				}
				else
					if(check(matrix, i, j)==false)
						return "impossible";	
		return "possible";
	}
	
	public static char[][] deepcopy(char[][] matrix)
	{
		char[][] result = new char[matrix.length][matrix[0].length];
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix[0].length; j++)
				result[i][j] = matrix[i][j];
		return result;	
	}
	
	public static boolean check(char[][] matrix, int row, int col)
	{
		char target = matrix[row][col];
		if(row+1<matrix.length)
			if(target == matrix[row+1][col])
				return false;
		if(row-1>=0)
			if(target == matrix[row-1][col])
				return false;
		if(col+1<matrix[0].length)
			if(target == matrix[row][col+1])
				return false;
		if(col-1>=0)
			if(target == matrix[row][col-1])
				return false;
		return true;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		char[][][] matrixs = new char[t][][];
		for(int i=0; i<t; i++)
		{
			String[] temp = in.nextLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int m = Integer.parseInt(temp[1]);
			matrixs[i] = new char[n][m];
			for(int j=0; j<n; j++)
				matrixs[i][j] = in.nextLine().toCharArray();
		}
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(matrixs[i], 0, 0));
		in.close();
	}
}
