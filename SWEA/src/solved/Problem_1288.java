package solved;

import java.util.HashSet;
import java.util.Scanner;

public class Problem_1288 {
	public static int solution(int n)
	{
		int k = 0;
		HashSet<Character> set = new HashSet<Character>();
		for(k=1; set.size() != 10; k++)
		{
			for(char a : String.valueOf(n*k).toCharArray())
				set.add(a);
		}
		return n*--k;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[] arr = new int[t];
		for(int i=0; i<t; i++)
			arr[i] = Integer.parseInt(in.nextLine());
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+ solution(arr[i]));
		in.close();
	}
}
