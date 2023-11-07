package solved;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem_1860 {
	public static String solution(int n, int m, int k, int[] w)
	{
		Arrays.sort(w);
		LinkedList<Integer> list = new LinkedList<>();
		for(int i : w)
			list.addLast(i);
		
		int stock = 0;
		int clock = 0;
		while(true)
		{
			if(clock%m == 0 && clock != 0)
				stock += k;
			
			while(list.peek() == clock)
			{
				if(--stock < 0)
					return "Impossible";
				list.remove();
				if(list.isEmpty())
					return "Possible";
			}
			clock++;
		}
	}
	
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int t = Integer.parseInt(in.nextLine());
    	int[] n = new int[t];
    	int[] m = new int[t];
    	int[] k = new int[t];
    	int[][] w = new int[t][];
    	
    	for(int i=0; i<t; i++)
    	{
    		String[] temp = in.nextLine().split(" ");
    		n[i] = Integer.parseInt(temp[0]);
    		m[i] = Integer.parseInt(temp[1]);
    		k[i] = Integer.parseInt(temp[2]);
    		temp = in.nextLine().split(" ");
    		w[i] = new int[temp.length];
    		for(int j=0; j<temp.length; j++)
    			w[i][j] = Integer.parseInt(temp[j]);
    	}
    	for(int i=0; i<t; i++)
    		System.out.println("#"+(i+1)+" " + solution(n[i],m[i],k[i],w[i]));
    	in.close();
    }
}

