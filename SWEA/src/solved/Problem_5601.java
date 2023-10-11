package solved;
import java.util.Scanner;

public class Problem_5601 {
	static void solution(int n) {
		for(int i=0; i<n; i++)
			System.out.print(" 1/"+n);
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int arr[] = new int[t];
		for(int i=0; i<t; i++)
		{
			int n = Integer.parseInt(in.nextLine());
			arr[i] = n;
		}
		for(int i=0; i<t; i++)
		{
			System.out.print("#"+(i+1));
			solution(arr[i]);
		}
		in.close();
	}
}
