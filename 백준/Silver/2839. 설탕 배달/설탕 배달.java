import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int solution(int n) {
		int cnt = 0;
		int value = n;
		while(true) {
			if(value < 0)
				return -1;
			if(value % 5 == 0) {
				cnt += value/5;
				return cnt;
			}
			else {
				cnt++;
				value -= 3;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(solution(n));
	}
}