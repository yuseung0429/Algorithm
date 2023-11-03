package solved;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem_1234 {
	static ArrayList<Integer> solution(ArrayList<Integer> list) {
		int i = 0;
		while(true)
		{
			if(i < 1)
				i++;
			if(i >= list.size())
				return list;
			else
				if(list.get(i) == list.get(i-1))
				{
					list.remove(i);
					list.remove(i-1);
					i--;
				}
				else
					i++;
		}
	}
	static ArrayList<Integer> convertStringArrayToIntegerArrayList(String[] arr)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++)
			result.add(Integer.parseInt(arr[i]));
		return result;
	}
	static void printArrayList(ArrayList<Integer> list)
	{
		for(Integer i : list)
			System.out.print(i);
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] arr = new ArrayList[10];
		for(int i=0; i<10; i++)
			arr[i] = convertStringArrayToIntegerArrayList(in.nextLine().split(" ")[1].split(""));
		for(int i=0; i<10; i++)
		{
			System.out.print("#"+(i+1)+" ");
			printArrayList(solution(arr[i]));
		}
		in.close();
	}
}
