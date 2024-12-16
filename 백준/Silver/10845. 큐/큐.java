import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			
			switch (temp[0]) {
				case "push": queue.addLast(Integer.parseInt(temp[1])); break;
				case "pop": sb.append(queue.isEmpty() ? -1 : queue.pollFirst()).append("\n"); break;
				case "size": sb.append(queue.size()).append("\n"); break;
				case "empty": sb.append(queue.isEmpty() ? 1 : 0).append("\n"); break;
				case "front": sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n"); break;
				case "back": sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n"); break;
			}
		}
		System.out.println(sb);
	}
}