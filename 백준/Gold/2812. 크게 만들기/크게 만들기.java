import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int k;
	
	public static void solution(char[] arr) {
		ArrayList<Character> stack = new ArrayList<Character>();
		int cnt = 0;
		int idx = 0;
		
		stack.add(arr[idx++]);
		StringBuilder sb = new StringBuilder();
			
		while (cnt < k && idx < arr.length) {
			if (stack.isEmpty() || stack.get(stack.size()-1) >= arr[idx]) {
				stack.add(arr[idx++]);
				continue;
			}
			stack.remove(stack.size()-1);
			cnt++;
		}
		
		for (; idx<arr.length; idx++) {
			stack.add(arr[idx]);
		}
		
		for(int i=cnt; i<k; i++) {
			stack.remove(stack.size()-1);
		}
		
		for (char c : stack) {
			sb.append(c);
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		
		solution(br.readLine().toCharArray());
	}
}