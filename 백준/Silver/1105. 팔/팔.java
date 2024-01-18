import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int solution(int start, int end) {
		char[] c1 = String.valueOf(start).toCharArray();
		char[] c2 = String.valueOf(end).toCharArray();
		if(c1.length != c2.length)
			return 0;
		int cnt = 0;
		for(int i=0; i<c1.length; i++) {
			if(c1[i] == c2[i]) {
				if(c1[i]=='8')
					cnt++;
				else
					continue;
			}
			else
				break;	
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int start = Integer.parseInt(temp[0]);
		int end = Integer.parseInt(temp[1]);
		System.out.println(solution(start, end));
	}
}