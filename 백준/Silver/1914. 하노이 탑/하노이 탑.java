import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
	static int input;
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = Integer.parseInt(br.readLine());
		if(input <= 20) {
			rec(1, 2, 3, input);
			System.out.println(cnt);
			System.out.println(sb.toString());
		} else
			System.out.println((new BigDecimal(2)).pow(input).subtract(new BigDecimal(1))); 
	}
	public static void rec(int start, int middle, int end, int n){
		if(n==0) return;
		rec(start, end, middle, n-1);
		cnt++;
		if(input <= 20) {
			sb.append(start);
			sb.append(" ");
			sb.append(end);
			sb.append("\n");
		}
		rec(middle, start, end, n-1);
	}
}