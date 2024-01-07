package solved;

import java.util.Scanner;

public class Problem_1974 {
    public static int solution(int[][] matrix)
    {
        if(rowcheck(matrix) && colcheck(matrix) && partcheck(matrix))
            return 1;
        else
            return 0;
    }
    
    public static int[] convert(String[] arr)
    {
        int[] result = new int[arr.length];
		for(int i=0; i<arr.length; i++)
            result[i] = Integer.parseInt(arr[i]);
        return result;
    }
    
    public static boolean rowcheck(int[][] matrix)
    {
        for(int i=0; i<9; i++)
        {
        	boolean[] flag = new boolean[9];
            for(int j=0; j<9; j++)
            {
                if(flag[matrix[i][j]-1] == true)
                	return false;
                else
                    flag[matrix[i][j]-1] =true;
            }
        }
        return true;
    }
    
    public static boolean colcheck(int[][] matrix)
    {
        for(int i=0; i<9; i++)
        {
        	boolean[] flag = new boolean[9];
            for(int j=0; j<9; j++)
            {
                if(flag[matrix[j][i]-1] == true)
                	return false;
                else
                    flag[matrix[j][i]-1] =true;
            }
        }
        return true;
    }
    
    public static boolean partcheck(int[][] matrix)
    {
        
        int row_area = 0;
        int col_area = 0;
        while(col_area != 3)
        {
        	boolean[] flag = new boolean[10];
        	for(int i=row_area; i<3; i++)
            {
                for(int j=col_area; j<3; j++)
                {
                    if(flag[matrix[i][j]-1] == true)
                    	return false;
                    else
                        flag[matrix[i][j]-1] = true;
                }
            }
        	row_area += 1;
            if(row_area == 3)
            {
            	row_area = 0;
            	col_area +=1;
            }
                
        }
        return true;
    }
    
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        int[][][] matrixs = new int[t][9][9];
        for(int i=0; i<t; i++)
         	for(int j=0; j<9; j++)
                matrixs[i][j] = convert(in.nextLine().split(" "));
        for(int i=0; i<t; i++)
            System.out.println("#"+(i+1)+" "+solution(matrixs[i]));
        in.close();
    }
}