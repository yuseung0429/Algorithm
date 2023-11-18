package solved;

import java.util.Scanner;

public class Problem_14555 {
	public static int solution(String ground)
	{
		int cnt = 0;
		int state = 0;
		char[] arr = ground.toCharArray();
		for(char pos : arr)
		{
			if(pos == '.')
				state = 0;
			else if(pos == '(')
				state = 1;
			else if((pos == ')' && state == 1) || (pos == '|' && state == 1))
			{
				cnt++;
				state = 0;
			}
			else if(pos == '|')
				state = 2;
			else if(pos == ')' && state == 2)
			{
				cnt++;
				state = 0;
			}
		}
		return cnt;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		String[] arr = new String[t];
		for(int i=0; i<t; i++)
			arr[i] = in.nextLine();
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(arr[i]));
		in.close();
	}
}
