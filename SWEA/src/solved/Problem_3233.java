package solved;

import java.util.Scanner;

public class Problem_3233 {
	public static long solution(int a, int b) {
		long q = a/b;
		long sum=0;
		for(int i=1; i<=q; i++)
			sum += (2*i-1);
		return sum;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int[] a = new int[t];
		int[] b = new int[t];
		for(int i=0; i<t; i++) {
			String[] temp = in.nextLine().split(" ");
			a[i] = Integer.parseInt(temp[0]);
			b[i] = Integer.parseInt(temp[1]);
		}
		for(int i=0; i<t; i++)
			System.out.println("#"+(i+1)+" "+solution(a[i], b[i]));
		in.close();
	}
}