package solved;

import java.util.Scanner;

public class Problem_1959 {
	
	public static int solution(int[] x, int[] y)
	{
		int interval = x.length - y.length;
		int max = 0;
		for(int i=0; i<=interval; i++)
		{
			int sumprod = 0;
			for(int j=0; j<y.length; j++)
				sumprod += x[i+j] * y[j];
			if(max < sumprod)
				max = sumprod;
		}
		return max;
	}
	
	public static int[] convert(String[] args)
	{
		int[] result = new int[args.length];
		for(int i=0; i<args.length; i++)
			result[i] = Integer.parseInt(args[i]);
		return result;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[][] a_arr = new int[t][];
		int[][] b_arr = new int[t][];
		for(int i=0; i<t; i++)
		{
			in.nextLine();
			a_arr[i] = convert(in.nextLine().split(" "));
			b_arr[i] = convert(in.nextLine().split(" "));
		}
		for(int i=0; i<t; i++)
		{
			boolean temp = a_arr[i].length > b_arr[i].length;
			int result = (temp) ? solution(a_arr[i],b_arr[i]) : solution(b_arr[i], a_arr[i]);
			System.out.println("#"+(i+1)+" "+result);
		}
		in.close();
	}
}
