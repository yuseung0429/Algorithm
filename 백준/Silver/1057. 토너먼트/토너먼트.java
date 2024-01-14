import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int a = Integer.parseInt(temp[1]);
		int b = Integer.parseInt(temp[2]);
		int count = 1;
		while(true) {
			int start = 1;
			while(start < n) {
				if(start <= a && start+2 > a && start <= b && start+2 > b) {
					System.out.println(count);
					return;
				}
				else
					start+=2;	
			}
			a = (a%2==0) ? a/2 : (a+1)/2;
			b = (b%2==0) ? b/2 : (b+1)/2;
			n = (n%2==0) ? n/2 : (n+1)/2;
			count++;
		}
	}
}
