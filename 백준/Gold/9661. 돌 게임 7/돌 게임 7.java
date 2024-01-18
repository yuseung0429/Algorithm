import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static String solution(long n) {
		long temp = n%5;
		boolean[] arr = new boolean[5];
		arr[0] = false;
		arr[1] = true;
		arr[2] = false;
		arr[3] = true;
		arr[4] = true;
		return (arr[(int)temp] == true) ? "SK" : "CY";
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		System.out.println(solution(n));
	}
}