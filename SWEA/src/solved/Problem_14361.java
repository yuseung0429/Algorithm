package solved;

import java.util.Scanner;

public class Problem_14361 {
	public static String solution(char[] nums) 
	{
		boolean[] visited = new boolean[nums.length];
		char[] cnums = nums.clone();
		return (recursion(nums, visited, cnums, 0) == true) ? "possible" : "impossible";
	}
	public static boolean recursion(char[] nums, boolean[] visited, char[] cnums, int step)
	{
		if(step == nums.length)
		{
			int n = Integer.parseInt(new String(nums));
			int value = Integer.parseInt(new String(cnums));
			if(value == n)
				return false;
			return value % n == 0;
		}
		if(cnums[0] == '0')
			return false;
		
		for(int i=0; i<nums.length; i++)
		{
			if(visited[i] == true)
				continue;
			else
			{
				visited[i]=true;
				cnums[step] = nums[i]; 
				if(recursion(nums, visited, cnums, step+1) == true)
					return true;
				visited[i]=false;
			}
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		String[] n = new String[t];
		for(int i=0; i<t; i++)
			n[i] = in.nextLine();
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(n[i].toCharArray()));
		in.close();
	}
}
