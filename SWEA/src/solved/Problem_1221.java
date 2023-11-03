package solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Problem_1221 {
	
	public static ArrayList<String> solution(ArrayList<String> arr)
	{
		HashMap<String, Integer> number = new HashMap<String, Integer>();
		number.put("ZRO", 0);
		number.put("ONE", 1);
		number.put("TWO", 2);
		number.put("THR", 3);
		number.put("FOR", 4);
		number.put("FIV", 5);
		number.put("SIX", 6);
		number.put("SVN", 7);
		number.put("EGT", 8);
		number.put("NIN", 9);

		arr.sort((o1, o2) -> number.get(o1) - number.get(o2));
		
		return arr;
	}
	
	public static void printArray(ArrayList<String> arr)
	{
		for(String temp : arr)
			System.out.print(temp + " ");
		System.out.println();
	}
	
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		@SuppressWarnings("unchecked")
		ArrayList<String>[] array = new ArrayList[t];
		for(int i=0; i<t; i++)
		{
			in.nextLine();
			String[] temp = in.nextLine().split(" ");
			array[i] = new ArrayList<String>(Arrays.asList(temp));
		}
		for(int i=0; i<t; i++)
		{
			System.out.println("#"+(i+1));
			printArray(solution(array[i]));
		}
		in.close();
	}
}
