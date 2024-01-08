package solved;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Problem_2948 {
	public static int solution(String[] a, String[] b)
	{
		HashSet<String> hs = new HashSet<String>();
		hs.addAll(Arrays.asList(a));
		int cnt=0;
		for(String temp : b)
			if(hs.contains(temp))
				cnt++;
		return cnt;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		String[][] listA = new String[t][];
		String[][] listB = new String[t][];
		for(int i=0; i<t; i++)
		{
			in.nextLine();
			listA[i] = in.nextLine().split(" ");
			listB[i] = in.nextLine().split(" ");
		}
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(listA[i], listB[i]));
		in.close();
	}
}
