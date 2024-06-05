import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static long solution(long n, long t) {
		long start = 1;
		long end = n*n;
		while(start<=end) {
			long mid = (start+end)/2;
			long result = 0;
			long value = Long.MAX_VALUE;
			long div = 1;
			while(value != 0 && div <= n) {
				value = Math.min(n, mid/div++);
				result += value;
			}
			if(result < t)
				start = mid+1;
			else	
				end = mid-1;
		}
		return start;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long t = Long.parseLong(br.readLine());
		System.out.println(solution(n, t)); 
	}
}
