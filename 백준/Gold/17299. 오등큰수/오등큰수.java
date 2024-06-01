import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Main {
	
	static Map<Integer, Integer> freq = new HashMap<>();
	static TreeMap<Integer, Integer> memory = new TreeMap<>();
	static int[] arr;
	
	public static void solution() {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> result = new Stack<>();
		Stack<Integer> stack = new Stack<>();
		for(int i = arr.length-1; i>=0;) {
			if(!stack.isEmpty() && freq.get(arr[i]) >= freq.get(stack.peek())) {
				stack.pop();
				continue;
			}
			if(stack.isEmpty())
				result.push(-1);
			else
				result.push(stack.peek());
			stack.push(arr[i]);
			i--;	
		}
		while(!result.isEmpty())
			sb.append(result.pop()).append(" ");
		System.out.println(sb);
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++) {
			int value = Integer.parseInt(temp[i]);
			if(freq.get(value) == null)
				freq.put(value, 1);
			else
				freq.put(value, freq.get(value)+1);
			result[i] = value;
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		arr = convert(br.readLine().split(" "));
		solution();
	}
}