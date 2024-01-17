import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static String solution(int n) {
		boolean[] arr = new boolean[ n<6 ? 6 : n+1];
		arr[0] = true; arr[1] = false; arr[2] = true;
		arr[3] = false; arr[4] = true; arr[5] = true;
		for(int i=6; i<=n; i++)
			arr[i] = !arr[i-1] || !arr[i-3] || !arr[i-4];
		return (arr[n] == true) ? "SK" : "CY";
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(solution(n));
	}
}
