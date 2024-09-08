import java.io.*;
import java.util.*;

public class Main{
	
	public static ArrayDeque<Character> stack;
	
	public static int solution() {
		int cnt = 0;
		while(!stack.isEmpty())
			cnt += rec();
		return cnt;
	}
	
	public static int rec(){
		char t = stack.pollLast();
		if(t >= '2' && t <= '9')
			return (t-'0')*rec();
		if(t == ')') {
			int cnt = 0;
			while(stack.peekLast() != '(')
				cnt += rec();
			stack.pollLast();
			return cnt;
		}
		switch(t){
			case 'H': return 1;
			case 'C': return 12;
			case 'O': return 16;
			default: return 0;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stack = new ArrayDeque<>();
		String temp = br.readLine();
		for(char c : temp.toCharArray())
			stack.add(c);
		System.out.println(solution());
	}
}