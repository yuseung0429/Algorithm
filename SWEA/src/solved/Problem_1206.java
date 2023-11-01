package solved;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem_1206 {
	static int solution(ArrayList<Integer> list) {
		int count = 0;
		list.add(0,0);
		list.add(0,0);
		list.add(0,list.size());
		list.add(0,list.size());
		for(int i=2; i<list.size()-2; i++)
		{
			int n = list.get(i)- Math.max(Math.max(list.get(i-2), list.get(i-1)), Math.max(list.get(i+1), list.get(i+2)));
			if(n>0)
				count += n;
		}
		return count;
	}
	static ArrayList<Integer> convertStringArrayToIntegerArrayList(String[] arr)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(String i : arr)
			list.add(Integer.parseInt(i));
		return list;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = 10;
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] arr = new ArrayList[10];
		for(int i=0; i<t; i++)
		{
			in.nextLine();
			arr[i] = convertStringArrayToIntegerArrayList(in.nextLine().split(" "));
		}
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+ solution(arr[i]));
		in.close();
	}
}
