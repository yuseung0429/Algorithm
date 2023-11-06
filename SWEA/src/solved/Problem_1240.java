package solved;

import java.util.Scanner;

public class Problem_1240 {
	public static int solution(int[][] matrix)
	{
		int[] result = new int[8];
		int idx_start=0;
		int find_row=-1;
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=matrix[i].length-1; (find_row == -1)&&(j>=0); j--)
				if(matrix[i][j] == 1)
				{
					find_row = i;
					idx_start = j-55;
					if(i+1 >= matrix.length)
						return 0;
					else
						i++;
					break;
				}
		}
		if(find_row == -1)
			return 0;
		else
		{
			for(int i=0; i<8; i++)
			{
				StringBuilder sb = new StringBuilder();
				for(int k=0; k<7; k++)
					sb.append(matrix[find_row][idx_start+7*i+k]);
				int target = Integer.parseInt(sb.toString(),2);
				result[i] = decode(target);
			}
			int osum = 0;
			int esum = 0;
			for(int i=0; i<result.length; i++)
			{
				if(i%2 == 0)
					esum += result[i];
				else
					osum += result[i];
			}
			if((esum*3+osum)%10 == 0)
				return osum+esum;
			else
				return 0;
		}
	}
	
	public static int decode(int num)
	{
		switch(num)
		{
		case 0b0001101: return 0;
		case 0b0011001: return 1;
		case 0b0010011: return 2;
		case 0b0111101: return 3;
		case 0b0100011: return 4;
		case 0b0110001: return 5;
		case 0b0101111: return 6;
		case 0b0111011: return 7;
		case 0b0110111: return 8;
		case 0b0001011: return 9;   
		};
		return -1;
	}
	
	public static int[] convertStringToIntArray(String str)
	{
		String[] temp = str.split("");
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i]);
		return result;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int array[][][] = new int[t][][];
		for(int i=0; i<t; i++)
		{
			String[] temp = in.nextLine().split(" ");
			int nrow = Integer.parseInt(temp[0]);
			array[i] = new int[nrow][];
			for(int j=0; j<nrow; j++)
				array[i][j] = convertStringToIntArray(in.nextLine());
		}
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1) + " " + solution(array[i]));
		in.close();
	}
}
