package solved;

import java.util.Scanner;

public class Problem_1215 {
	public static int solution(int n, char[][] array)
	{
		int freq = 0;
		for(int i=0; i<8; i++)
			freq += row(n, array[i]);
		array = transpose(array, array.length, array[0].length);
		for(int i=0; i<8; i++)
			freq += row(n, array[i]);
		return freq;
	}
	public static char[][] transpose(char[][] array, int nrow, int ncol)
	{
		char[][] result = new char[ncol][nrow];
		for(int i=0; i<ncol; i++)
			for(int j=0; j<nrow; j++)
				result[i][j] = array[j][i];
		return result;
		
	}
	
	public static int row(int n, char[] row)
	{
		int freq = 0;
		if(n%2 == 0)
		{
			for(int i=(n/2-1); i<row.length-(n/2); i++)
			{
				if(row[i] != row[i+1])
					continue;
				int j;
				for(j=1; j<(n/2); j++)
				{
					if(row[i-j] != row[i+1+j])
						break;
				}
				if(j == n/2)
					freq++;
			}
		}
		else
		{
			for(int i=(n/2); i<row.length-(n/2); i++)
			{
				int j;
				for(j=1; j<=(n/2); j++)
				{
					if(row[i-j] != row[i+j])
						break;
				}
				if(j == (n/2+1))
					freq++;
			}
		}
		return freq;
	}
	
	public static void main(String[] args)
	{
		int count[] = new int[10];
		char array[][][] = new char[10][8][8];
		Scanner in = new Scanner(System.in);
		for(int i=0; i<10; i++)
		{
			count[i] = Integer.parseInt(in.nextLine());
			for(int j=0; j<8; j++)
				array[i][j] = in.nextLine().toCharArray();
		}
		for(int i=0; i<10; i++)
			System.out.println("#"+(i+1) + " " + solution(count[i], array[i]));
		in.close();
	}
}
