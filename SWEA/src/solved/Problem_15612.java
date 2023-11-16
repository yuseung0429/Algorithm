package solved;

import java.util.Scanner;

public class Problem_15612 {
	public static String solution(String[][] matrix)
	{
		int cnt = 0;
		for(int i=0; i<8; i++)
			for(int j=0; j<8; j++)
				if(matrix[i][j].equals("O"))
				{
					if(check(matrix, i, j)==false)
						return "no";
					cnt++;
				}
		return (cnt==8) ? "yes" : "no";
	}
	
	public static boolean check(String[][] matrix, int row, int col)
	{
		for(int i=0; i<8; i++)
			if(i== row)
				continue;
			else
				if(matrix[i][col].equals("O"))
					return false;
		for(int j=0; j<8; j++)
			if(j== col)
				continue;
			else
				if(matrix[row][j].equals("O"))
					return false;
		return true;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		String[][][] matrixs = new String[t][8][8];
		
		for(int i=0; i<t; i++)
			for(int j=0; j<8; j++)
				matrixs[i][j] = in.nextLine().split("");
		
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(matrixs[i]));
		
		in.close();
	}
}
