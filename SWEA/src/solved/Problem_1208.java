package solved;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem_1208 {
	static int solution(ArrayList<Integer> list, int cnt) {
		list.sort((o1, o2) -> o2-o1);
		while(cnt!=0)
		{
			list.set(0, list.get(0) - 1);
			list.set(list.size()-1, list.get(list.size()-1) + 1);
			cnt--;
			list.sort((o1, o2) -> o2-o1);
		}
		return list.get(0) - list.get(list.size()-1);
	}
	static ArrayList<Integer> convertArrayStringToInteger(String[] arr)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(String temp : arr)
			result.add(Integer.parseInt(temp));
		return result;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int[] cnt = new int[10];
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] list = new ArrayList[10];
		for(int i=0; i<10; i++)
		{
			cnt[i] = Integer.parseInt(in.nextLine());
			list[i] = convertArrayStringToInteger(in.nextLine().split(" "));
		}
		for(int i=0; i<10; i++)
			System.out.println("#"+(i+1)+" "+ solution(list[i], cnt[i]));
		in.close();
	}
}
