package solved;

import java.util.Scanner;

public class Problem_15758 {
	public static String solution(String[] pairs)
	{
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int len1 = pairs[0].length();
		int len2 = pairs[1].length();
		
		sb1.append(pairs[0]);
		sb2.append(pairs[1]);
		
		while(true)
		{
			if (len1 > len2)
			{
				sb2.append(pairs[1]);
				len2 += pairs[1].length();
			}
			else if (len1 < len2)
			{
				sb1.append(pairs[0]);
				len1 += pairs[0].length();
			}
			else
				break;
		}
		boolean result = sb1.toString().equals(sb2.toString());
		return result ? "yes" : "no";
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		String[][] arr = new String[t][]; 
		for(int i=0; i<t; i++)
			arr[i] = in.nextLine().split(" ");
		for(int i=0; i<t; i++)
			System.out.println("#" + (i+1) +" "+ solution(arr[i]));
		in.close();
	}
}
