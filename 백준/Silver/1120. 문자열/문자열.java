import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int solution(String a, String b) {
		char[] ca = a.toCharArray();
		char[] cb = b.toCharArray();
		
		int max_cnt = 0;
		
		for(int i=0; i<=cb.length - ca.length; i++) {
			int cnt = 0;
			for(int j=0; j<ca.length && j+i<cb.length; j++)
				if(ca[j] == cb[j+i])
					cnt++;
			if(max_cnt < cnt)
				max_cnt = cnt;
		}
		return ca.length - max_cnt;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		System.out.println(solution(temp[0], temp[1]));
	}
}