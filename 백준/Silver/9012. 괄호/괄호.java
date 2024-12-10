import java.io.*;
import java.util.*;

class Main {
	
	public static String solution(char[] arr) {
		ArrayDeque<Character> stack = new ArrayDeque<Character>();
		for(char c : arr) {
			if(c == '(') {
				stack.addLast('(');
				continue;
			}
			
			if(stack.isEmpty()) {
				return "NO";
			}
			
			stack.pollLast();
		}
		
		return stack.isEmpty() ? "YES" : "NO";
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int i=0; i<t; i++) {
			sb.append(solution(br.readLine().toCharArray())).append("\n");
		}
		
		System.out.println(sb);
	}
}