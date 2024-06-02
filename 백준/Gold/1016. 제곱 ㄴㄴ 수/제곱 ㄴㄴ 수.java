import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		HashSet<Long> set = new HashSet<>();
		
		long min = Long.parseLong(temp[0]);
		long max = Long.parseLong(temp[1]);
		
		long limit = (long) Math.sqrt(max);
		
		boolean[] visited = new boolean[(int) (limit + 1)];
		
		for(long i=2; i<=limit; i++) {
			if(visited[(int) i])
				continue;
			long original = i * i;
			long index = i;
			while(index <= limit) {
				visited[(int) index] = true;
				index += i;
			}
			
			long value = ((min-1)/original+1)*original;
			while(value <= max) {
				if(value >= min)
					set.add(value);
				value += original;
			}
		}
		System.out.println(max + 1 - min - set.size());
	}
}
