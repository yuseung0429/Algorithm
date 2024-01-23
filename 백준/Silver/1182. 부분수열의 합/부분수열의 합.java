import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int total;
	static int[] arr;
	static int n;
	static int s;

	public static int solution() {
		rec(0, 0, false);
		return total;
	} 
	
	public static void rec(int sum, int idx, boolean flag) {
		if(sum == s && flag == true)
			total++;
		if(idx == arr.length)
			return;

		rec(sum+arr[idx], idx+1, true);
		rec(sum, idx+1, false);
		
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i]);
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		s = Integer.parseInt(temp[1]);
		arr = convert(br.readLine().split(" "));
		System.out.println(solution());
	}
}