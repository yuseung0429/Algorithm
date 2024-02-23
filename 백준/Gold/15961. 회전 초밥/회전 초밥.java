import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static int n;
	static int d;
	static int k;
	static int c;
	static int[] arr;
	
	public static int solution() {
		int max = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<k; i++) {
			Integer value = map.get(arr[i]);
			if(value == null)
				map.put(arr[i], 1);
			else
				map.put(arr[i], value+1);
		}
		
		for(int i=0; i<n; i++) {
			max = Math.max(max, map.size() + (map.containsKey(c) ? 0 : 1));
			if(max == k+1)
				return k+1;
			Integer value = map.get(arr[i]);
			if(value.intValue() == 1)
				map.remove(arr[i]);
			else
				map.put(arr[i], value-1);
			
			int next = (i+k)%n;
				
			value = map.get(arr[next]);
			if(value == null)
				map.put(arr[next], 1);
			else
				map.put(arr[next], value+1);
		}
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]); 
		d = Integer.parseInt(temp[1]); 
		k = Integer.parseInt(temp[2]); 
		c = Integer.parseInt(temp[3]);
		arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(br.readLine());	
		System.out.println(solution());
	}
}
