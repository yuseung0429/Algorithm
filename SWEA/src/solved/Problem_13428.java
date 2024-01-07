package solved;

import java.util.Scanner;

public class Problem_13428 {
	public static String solution(String[] arr)
	{
		StringBuilder min_sb = new StringBuilder();
		StringBuilder max_sb = new StringBuilder();
		int[] nums = new int[arr.length];
		for(int i=0; i<arr.length; i++)
			nums[i] = Integer.parseInt(arr[i]);
		
		int[] min_nums = nums.clone();
		getMin(min_nums, 0);
		for(int i : min_nums)
			min_sb.append(i);
		
		int[] max_nums = nums.clone();
		getMax(max_nums, 0);
		for(int i : max_nums)
			max_sb.append(i);
		return min_sb.toString()+" "+ max_sb.toString();
	}
	public static void getMin(int[] nums, int step)
	{
		if(step == nums.length)
			return;
		int min = nums[step];
		int min_idx = step;
		for(int i=nums.length-1; i>step; i--)
		{
			if(min > nums[i])
			{
				if(step==0 && nums[i]==0)
					continue;
				min = nums[i];
				min_idx = i;
			}
		}
		if (nums[step] == nums[min_idx])
			getMin(nums, step+1);
		else
			swap(nums, step, min_idx);
	}
	
	public static void getMax(int[] nums, int step)
	{
		if(step == nums.length)
			return;
		
		int max = nums[step];
		int max_idx = step;
		
		for(int i=nums.length-1; i>step; i--)
		{
			if(max < nums[i])
			{
				max = nums[i];
				max_idx = i;
			}
		}
		if (nums[step] == nums[max_idx])
			getMax(nums, step+1);
		else
			swap(nums, step, max_idx);
	}
	public static int[] swap(int[] nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		return nums;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		String[] n = new String[t];
		for(int i=0; i<t; i++)
			n[i] = in.nextLine();
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+ solution(n[i].split("")));
		in.close();
	}
}
