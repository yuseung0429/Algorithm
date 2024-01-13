import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void solution(int n, int l) {
		int end = l-1;
		int sum = end*(end+1)/2;
		while(l <= 100) {
			if(sum > n) {
				end = ++l-1;
				sum = end*(end+1)/2;
			}	
			else if(sum < n) {
				sum += ++end;
				sum -= end-l;
			}
			else {
				for(int i = end-l+1; i<=end; i++)
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