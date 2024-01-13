import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void solution(int n, int l) {
		int sum = 0;
		int start = 0;
		int end = l-1;
		for(int i=0; i<l; i++)
			sum += i;
		while(l <= 100) {
			if(sum > n) {
				sum = 0;
				start = 0;
				end = ++l-1;
				for(int i=0; i<l; i++)
					sum += i;
			}	
			else if(sum < n) {
				sum -= start++;
				sum += ++end;
			}
			else {
				for(int i = start; i<=end; i++)
					System.out.print(i+" ");
				return;
			}	
		}
		System.out.print(-1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int l = Integer.parseInt(temp[1]);
		solution(n,l);
	}
}