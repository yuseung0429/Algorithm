package solved;

import java.util.Scanner;

public class Problem_13547 {
	public static String solution(char[] arr)
	{
		int cnt = 0;
		for(char c : arr)
			if(c == 'x')
				cnt++;
		return (cnt < 8) ? "YES" : "NO";
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		String[] arr = new String[t];
		for(int i=0; i<t; i++)
			arr[i] = in.nextLine();
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(arr[i].toCharArray()));
		in.close();
	}
}
