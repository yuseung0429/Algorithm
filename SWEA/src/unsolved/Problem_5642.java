package unsolved;

import java.util.Scanner;

public class Problem_5642 {
	
	static public int solution(int n, int[] arr) {
		int max = 0;
		for(int i=0; i<n; i++)
			max += arr[i];
		int sum = max;
		for(int i=n; i<arr.length; i++)
		{
			sum = sum - arr[i-n] + arr[n];
			if(max > sum)
			{
				System.out.println(max);
				max = sum;
			}
		}
		return max;
	}
	
	static int[] convertArrayStringToInteger(String[] arr)
	{
		int[] result = new int[arr.length];
		for(int i=0; i<arr.length; i++)
			result[i] = Integer.parseInt(arr[i]);
		return result;
	}
	
	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		int[] arr = convertArrayStringToInteger(in.nextLine().split(" "));
		System.out.println(solution(n, arr));
		in.close();
	}
}
