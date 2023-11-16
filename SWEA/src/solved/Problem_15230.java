package solved;

import java.util.Scanner;

public class Problem_15230 {
	public static int solution(char[] arr)
	{
		int cnt = 0; 
		char start = 97;
		for(char target : arr)
		{
			if(start == target)
			{
				cnt++;
				start++;
			}
			else
				break;
		}
		return cnt;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		char[][] arr = new char[t][];
		for(int i=0; i<t; i++)
			arr[i] = in.nextLine().toCharArray();
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" " +solution(arr[i]));
		in.close();
	}
}
