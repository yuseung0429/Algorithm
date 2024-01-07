package solved;

import java.util.Scanner;

public class Problem_1961 {
	public static int[][] rotate(int[][] matrix){
		int n = matrix.length;
		int[][] result = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				result[j][(n-1)-i] = matrix[i][j];
		return result;
	}
	
	public static void print(int[][] r90, int[][] r180, int[][] r270)
	{
		int n = r90.length;
		for(int i=0; i<n; i++)
		{
			for(int a: r90[i]) System.out.print(a);
			System.out.print(" ");
			for(int a: r180[i]) System.out.print(a);
			System.out.print(" ");
			for(int a: r270[i]) System.out.print(a);
			System.out.println();
		}
	}
	
    public static int[] convert(String[] arr)
    {
        int[] result = new int[arr.length];
		for(int i=0; i<arr.length; i++)
            result[i] = Integer.parseInt(arr[i]);
        return result;
    }
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[][][] matrixs = new int[t][][];
		for(int i=0; i<t; i++)
		{
			int n = Integer.parseInt(in.nextLine());
			matrixs[i] = new int[n][n];
			for(int j=0; j<n; j++)
				matrixs[i][j] = convert(in.nextLine().split(" "));
		}
		for(int i=0; i<t; i++)
		{
			System.out.println("#" + (i+1));
			int[][] r90 = rotate(matrixs[i]);
			int[][] r180 = rotate(r90);
			int[][] r270 = rotate(r180);
			print(r90, r180, r270);
		}
		in.close();
	}
}
