package solved;

import java.util.Scanner;

public class Problem_3032 {
	public static int[] solution(int[] coef) {
		boolean isbig = (coef[0]>coef[1]) ? true : false;
		int a = (isbig) ? coef[0] : coef[1];
		int b = (isbig) ? coef[1] : coef[0];
		if(isbig == true) {
			a = coef[0];
			b = coef[1];
		}
		else {
			a = coef[1];
			b = coef[0];
		}
		int temp = 0;
		int s0 = 1;
		int t0 = 0;
		int s1 = 0;
		int t1 = 1;
		int q = 0;
		
		while(b !=0)
		{
			q = a/b;
			
			temp = b;
			b = a%b;
			a = temp;
			
			temp = s1;
			s1 = s0 - s1*q;
			s0 = temp;
			
			temp = t1;
			t1 = t0 - t1*q;
			t0 = temp;
		}
		int[] result = new int[2];
		result[0] = (isbig) ? s0 : t0;
		result[1] = (isbig) ? t0 : s0;

		return result;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[][] coef = new int[t][2];
		for(int i=0; i<t; i++) {
			String[] temp = in.nextLine().split(" ");
			coef[i][0] = Integer.parseInt(temp[0]);
			coef[i][1] = Integer.parseInt(temp[1]);
		}
		for(int i=0; i<t; i++)
		{
			int[] temp = solution(coef[i]);
			System.out.println("#"+(i+1)+" "+temp[0]+" "+temp[1]);
		}
		in.close();
	}
}