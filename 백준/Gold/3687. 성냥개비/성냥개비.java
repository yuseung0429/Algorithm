import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] problems;
	static int[] numberStick = new int[] {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
	static long[] smalls = new long[101];

	public static void solution() {
		StringBuilder sb = new StringBuilder();
		for(int problem : problems)
			sb.append(smallNumber(problem)).append(" ").append(bigNumber(problem)).append("\n");
		System.out.println(sb);
	}
	
	public static String bigNumber(int stick) {
		StringBuilder sb = new StringBuilder();
		while(true) {
			if(stick == 0)
				break;
			if(stick == 3) {
				stick -= 3;
				sb.append("7");
			}	
			else {
				stick -= 2;
				sb.append("1");
			}
		}
		return sb.reverse().toString();		
	}
	
	public static String smallNumber(int stick) {
		return String.valueOf(smalls[stick]);
	}
	
	private static void initSmalls() {
		Arrays.fill(smalls, Long.MAX_VALUE);
		smalls[2] = 1;
		smalls[3] = 7;
		smalls[4] = 4;
		smalls[5] = 2;
		smalls[6] = 6;
		smalls[7] = 8;
		
		for(int i=2; i<101; i++)
			for(int j=0; j<10; j++)
				if(i+numberStick[j]<101)
					smalls[i+numberStick[j]] = Math.min(smalls[i+numberStick[j]], smalls[i]*10+j);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		problems = new int[t];
		for(int i=0; i<t; i++)
			problems[i] = Integer.parseInt(br.readLine());
		
		initSmalls();
		solution();
	}
}
