import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int n;
	static boolean[] sifter;
	static ArrayList<Integer> primes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sifter = new boolean[n+1];
		primes = new ArrayList<Integer>();
		
		for(int i=2; i<=n; i++)
			if(sifter[i] == false) {
				for(int j=2*i; j<=n; j+=i)
					sifter[j] = true;
				primes.add(i);
			}
		int cnt = 0;
		int size = primes.size();
		for(int i=0; i<size; i++) {
			int sum = 0;
			int j = i;
			while(sum < n && j != size)
				sum += primes.get(j++);
			if(sum == n)
				cnt++;
		}
		System.out.println(cnt);
	}
}