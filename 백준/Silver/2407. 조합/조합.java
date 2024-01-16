import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
	public static String solution(int n, int m) {
		m = Math.min(m, n-m);
		BigDecimal numerator = new BigDecimal(1);
		BigDecimal denominator = new BigDecimal(1);
		for(int i=0; i<m; i++) {
			numerator = numerator.multiply(new BigDecimal(n-i));
			denominator = denominator.multiply(new BigDecimal(i+1));
		}
		return numerator.divide(denominator).toString();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		System.out.println(solution(n, m));
	}
}