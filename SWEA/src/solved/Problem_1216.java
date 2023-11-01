package solved;

import java.util.Scanner;

public class Problem_1216 {
	public static int solution(char[][] array)
	{
		int max = 0;
		int rmax= 0;
		for(int i=0; i<100; i++)
		{
			rmax = row(array[i]);
			if(rmax > max)
				max = rmax;
		}
		array = transpose(array, array.length, array[0].length);
		for(int i=0; i<100; i++)
		{
			rmax = row(array[i]);
			if(rmax > max)
				max = rmax;
		}
		return max;
	}
	public static char[][] transpose(char[][] array, int nrow, int ncol)
	{
		char[][] result = new char[ncol][nrow];
		for(int i=0; i<ncol; i++)
			for(int j=0; j<nrow; j++)
				result[i][j] = array[j][i];
		return result;
	}
	
	public static int row(char[] row)
	{
		int max = 0;
		for(int i=1; i<row.length-1; i++)
		{
			int j;
			for(j=1; ;j++)
			{
				if(i-j < 0 || i+j >= row.length)
					break;
				if(row[i-j] != row[i+j])
					break;
			}
			int n = 1+2*(j-1);
			if(n > max)
				max = n;
		}
		
		for(int i=0; i<row.length-2; i++)
		{
			if(row[i] != row[i+1])
				continue;
			int j;
			for(j=1; ;j++)
			{
				if(i-j < 0 || i+1+j >= row.length)
					break;
				if(row[i-j] != row[i+1+j])
					break;
			}
			int n = 2+2*(j-1);
			if(n > max)
				max = n;
		}
		return max;
	}
	
	public static void main(String[] args)
	{
		char array[][][] = new char[10][100][100];
		Scanner in = new Scanner(System.in);
		for(int i=0; i<10; i++)
		{
			in.nextLine();
			for(int j=0; j<100; j++)
				array[i][j] = in.nextLine().toCharArray();
		}
		for(int i=0; i<10; i++)
			System.out.println("#"+(i+1) + " " + solution(array[i]));
		in.close();
	}
}