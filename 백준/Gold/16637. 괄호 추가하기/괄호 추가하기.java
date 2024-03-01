import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static ArrayList<Integer> nums;
	public static ArrayList<Character> op;
	public static int result = Integer.MIN_VALUE;
	public static boolean[] selected;
	public static int[] save;
	public static int n;
	public static int solution() {
		if(n == 1)
			return nums.get(0);
		rec(1);
		selected[0] = true;
		rec(1);
		return result;
	}
	
	public static void rec(int step) {
		if(step == op.size()) {
			int value = calculate();
			result = Math.max(value, result);
			return;
		}
		rec(step+1);
		if(!selected[step-1]) {
			selected[step] = true;
			rec(step+1);
			selected[step] = false;
		}
	}
	
	public static int calculate() {
		int last = 0;
		save[last++] = nums.get(0);
		for(int i=0; i<selected.length; i++) {
			if(selected[i])
				switch(op.get(i)) {
				case '+': save[last-1] += nums.get(i+1); break;
				case '-': save[last-1] -= nums.get(i+1); break;
				case '*': save[last-1] *= nums.get(i+1); break;
				}
			else
				save[last++] = nums.get(i+1);
		}
		int pos = 0;
		int result = save[pos++];
		for(int i=0; i<selected.length; i++) {
			if(selected[i])
				continue;
			switch(op.get(i)) {
			case '+': result += save[pos++]; break;
			case '-': result -= save[pos++]; break;
			case '*': result *= save[pos++]; break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new ArrayList<>();
		op = new ArrayList<>();
		String temp = br.readLine();
		for(int i=0; i<temp.length(); i++)
			switch (temp.charAt(i)){
			case '+', '-', '*': op.add(temp.charAt(i)); break;
			default : nums.add(temp.charAt(i)-'0');
			}
		save = new int[nums.size()];
		selected = new boolean[op.size()];
		System.out.println(solution());
	}
}
