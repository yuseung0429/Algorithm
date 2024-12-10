import java.io.*;
import java.util.*;
	
class Main {
	
	public static void solution(int[] arr) {
		ArrayDeque<int[]> stack = new ArrayDeque<int[]>();
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<arr.length;) {
			if (stack.isEmpty()) {
				stack.addLast(new int[]{arr[i], i+1});
				sb.append(0).append(" ");
				i++;
				continue;
			}
			
			int[] stackTop = stack.peekLast();	
			if (stackTop[0] < arr[i]) {
				stack.pollLast();
				continue;
			}
			
			stack.addLast(new int[]{arr[i], i+1});
			sb.append(stackTop[1]).append(" ");
			i++;
		}		
		
		System.out.println(sb);
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for (int i=0; i<temp.length; i++) {
			result[i] = Integer.parseInt(temp[i]);
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		solution(convert(br.readLine().split(" ")));
	}
}
