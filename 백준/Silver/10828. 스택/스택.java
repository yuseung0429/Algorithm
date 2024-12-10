import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		
		int t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			String[] temp = br.readLine().split(" ");
			switch(temp[0]){
			case "push": stack.addLast(Integer.parseInt(temp[1])); break;
			case "pop": sb.append(stack.peekLast() != null ? stack.pollLast() : -1).append("\n"); break;
			case "empty": sb.append(stack.isEmpty() ? 1 : 0).append("\n"); break;
			case "top": sb.append(stack.peekLast() != null ? stack.peekLast() : -1).append("\n"); break;
			case "size": sb.append(stack.size()).append("\n"); break;
			}
		}
		
		System.out.println(sb);
	}
}