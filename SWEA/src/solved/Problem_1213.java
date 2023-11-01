package solved;

import java.util.Scanner;

public class Problem_1213 {
	
	static public int solution(String str, String target)
	{
		int i = 0;
		int freq = 0;
		while(true)
		{
			i = str.indexOf(target, i);
			if(i != -1)
			{
				freq++;
				i += target.length();
			}
			else
				break;
		}
		return freq;
		
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String[] target = new String[10];
		String[] str = new String[10];
		
		for(int i = 0; i < 10; i++)
		{
			in.nextLine();
			target[i] = in.nextLine();
			str[i] = in.nextLine();
		}
		for(int i = 0; i < 10; i++)
			System.out.println("#"+(i+1) + " " +solution(str[i], target[i]));
		in.close();
	}
}
