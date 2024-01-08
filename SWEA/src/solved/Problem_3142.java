package solved;

import java.util.Scanner;

public class Problem_3142 {
	public static int[] solution(int horn, int unit) {
		int i = 0;
		int j = unit;
		while(true)
		{
			if((1*i + 2*j) == horn)
				break;
			i++;
			j--;
		}
		int[] result = new int[2];
		result[0] = i;
		result[1] = j;
		return result;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[] horn = new int[t];
		int[] unit = new int[t];
		for(int i=0; i<t; i++) {
			String[] temp = in.nextLine().split(" ");
			horn[i] = Integer.parseInt(temp[0]);
			unit[i] = Integer.parseInt(temp[1]);
		}
		for(int i=0; i<t; i++) {
			int[] temp = solution(horn[i], unit[i]);
			System.out.println("#"+(i+1)+" "+ temp[0] + " " + temp[1]); 
		}
		in.close();
	}
}
