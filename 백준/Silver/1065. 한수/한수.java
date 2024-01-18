import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int solution(int n) {
		int count = 0;
		for(int i=1; i<=n; i++)
			if(check(i) == true)
				count++;
		return count;
	}
	public static boolean check(int n) {
		char[] arr = String.valueOf(n).toCharArray();
		if(arr.length == 1)
			return true;
		else {
			int interval = arr[0] - arr[1];
			for(int i=0; i<arr.length-1; i++)
				if(arr[i] - arr[i+1] != interval)
					return false;
			return true;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(solution(n));
	}
}