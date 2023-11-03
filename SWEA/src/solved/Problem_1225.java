package solved;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Problem_1225 {
	
	public static ArrayDeque<Integer> solution(ArrayDeque<Integer> array)
	{
		while(true)
		{
			if(array.peekLast() == 0)
				return array;
			else
				doCycle(array);
		}
	}
	
	public static ArrayDeque<Integer> doCycle(ArrayDeque<Integer> array)
	{
		for(int i=1; i<=5; i++)
		{
			int n = array.poll() - i;
			if(n <= 0)
			{
				n = 0;
				array.addLast(n);
				break;
			}
			array.addLast(n);
		}
		return array;
	}
	
	public static Integer[] convertStringArraytoIntegerArray(String[] str)
	{
		Integer[] array = new Integer[str.length];
		for(int i=0; i<str.length; i++)
			array[i] = Integer.parseInt(str[i]);
		return array;
	}
	public static void printList(ArrayDeque<Integer> array)
	{
		for(Integer i: array)
			System.out.print(" " + i);
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		@SuppressWarnings("unchecked")
		ArrayDeque<Integer>[] array = new ArrayDeque[10];
		for(int i=0; i<10; i++)
		{
			in.nextLine();
			array[i] = new ArrayDeque<Integer>(Arrays.asList(convertStringArraytoIntegerArray(in.nextLine().split(" "))));
		}
			
		for(int i=0; i<10; i++)
		{
			System.out.print("#" + (i+1));
			printList(solution(array[i]));
		}
		in.close();
	}
}
