package solved;
import java.util.Scanner;

public class Problem_5603 {
	static int solution(int[] arr) {
		int sum = 0;
		for(int i : arr)
			sum += i;
		int avg = sum/arr.length;
		
		sum = 0;
		for(int i : arr)
			sum += Math.abs(avg - i);
		return sum/2;
	}
	
	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[][] arrs = new int[t][];
		for(int i=0; i<t; i++)
		{
			int n = Integer.parseInt(in.nextLine());
			int[] arr = new int[n];
			for(int j=0; j<n; j++)
				arr[j] = Integer.parseInt(in.nextLine());
			arrs[i] = arr;
		}
		for(int i=0; i<t; i++)
			System.out.println("#" + (i+1) + " " + solution(arrs[i]));
		in.close();
	}
}
