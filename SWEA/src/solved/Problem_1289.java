package solved;

import java.util.Scanner;

public class Problem_1289 {
	public static int solution(String seq)
	{
		int cnt = 0;
		char toggle_value = '0';
		for(char bit : seq.toCharArray())
		{
			if(bit != toggle_value)
			{
				toggle_value = bit;
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		String[] sequence = new String[t];
		for(int i=0; i<t; i++)
			sequence[i] = in.nextLine();
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(sequence[i]));
		in.close();
	}
}
