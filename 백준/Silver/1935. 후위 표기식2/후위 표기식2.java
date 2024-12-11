import java.io.*;
import java.util.*;

class Main {
	
	public static double[] arr;
	public static int n;
	
	public static double solution(char[] expression) {
		ArrayDeque<Double> stack = new ArrayDeque<Double>();
		
		for(char c : expression) {
			if('A'<=c && 'Z'>=c) {
				stack.addLast(arr[c-'A']);
				continue;
			}
				
			double back = stack.pollLast();
			double front = stack.pollLast();
							
			switch(c) {
			case '*': stack.addLast(front*back); break;
			case '+': stack.addLast(front+back); break;
			case '/': stack.addLast(front/back); break;
			case '-': stack.addLast(front-back); break;
			}
		}
		
		return stack.pollLast();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		char[] expression = br.readLine().toCharArray();
		arr = new double[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		
		System.out.println(String.format("%.2f", solution(expression)));
	}
}
