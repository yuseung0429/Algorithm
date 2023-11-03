package solved;

import java.util.Scanner;

public class Problem_1220 {
	static int solution(int[][] matrix) {
		int cnt = 0;
		for(int i=0; i<matrix[0].length; i++)
		{
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<matrix.length; j++)
				sb.append(matrix[j][i]);
			cnt += confirm(sb.toString());
		}
		return cnt;
	}
	static int confirm(String col)
	{
		col = col.replace("0", "");
		int cnt = 0;
		boolean state = false;
		char[] array = col.toCharArray();
		for(char i : array)
		{
			if(i=='1')
			{
				if(state == false)
					state = true;
				else
					continue;
			}
			else
			{
				if(state == false)
					continue;
				else
				{
					state=false;
					cnt++;
				}
			}
		}
		return cnt;
	}
	static int[] convertStringArrayToIntegerArray(String[] arr)
	{
		int[] result = new int[arr.length];
		for(int i=0; i<arr.length; i++)
			result[i] = Integer.parseInt(arr[i]);
		return result;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int matrixs[][][] = new int[10][100][100];
		for(int i=0; i<10; i++)
		{
			in.nextLine();
			for(int j=0; j<100; j++)
				matrixs[i][j] = convertStringArrayToIntegerArray(in.nextLine().split(" "));
		}
		for(int i=0; i<10; i++)
			System.out.println("#"+(i+1)+" "+ solution(matrixs[i]));
		in.close();
	}
}
