import java.util.*;
import java.io.*;

class Main{
	static int n;
	static int[] arr;
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void rec(int value, int plus, int minus, int multi, int divide, int step){
		if(step == n-1){
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}
		
		if(plus != 0)
			rec(value+arr[step+1], plus-1, minus, multi, divide, step+1);
			
		if(minus != 0)
			rec(value-arr[step+1], plus, minus-1, multi, divide, step+1);
			
		if(multi != 0)
			rec(value*arr[step+1], plus, minus, multi-1, divide, step+1);
			
		if(divide != 0)
			rec(value/arr[step+1], plus, minus, multi, divide-1, step+1);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		arr = new int[temp.length];
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(temp[i]);
		temp = br.readLine().split(" ");
		int plus = Integer.parseInt(temp[0]);
		int minus = Integer.parseInt(temp[1]);
		int multi = Integer.parseInt(temp[2]);
		int divide = Integer.parseInt(temp[3]);
			
		rec(arr[0], plus, minus, multi, divide, 0);
		
		System.out.println(max);
		System.out.println(min);
	}
}
