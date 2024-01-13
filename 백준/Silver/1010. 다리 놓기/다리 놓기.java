import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static long solution(int n, int r) {
		long top = 1;
		long bottom = 1;
		
		int temp_n = n;
		r = Math.min(r, n-r);
		int temp_r = r;
		
		for(int i=0; i<r; i++) {
			top *= temp_n--;
			bottom *= temp_r--;
		}
		return top / bottom;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] r = new int[t];
		int[] n = new int[t];
		for(int i=0; i<t; i++) {
			String[] temp = br.readLine().split(" ");
			r[i] = Integer.parseInt(temp[0]);
			n[i] = Integer.parseInt(temp[1]);
		}
		for(int i=0; i<t; i++)
			System.out.println(solution(n[i], r[i]));
	}
}
