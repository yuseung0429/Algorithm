import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
	static long[] arr;
	static HashMap<Integer, Long> map;
	public static void change(int k, long v) {
		map.put(k, v);
	}
	
	public static long sum(int start, int end) {
		long result = arr[end] - arr[start-1];
		for(Entry<Integer, Long> node : map.entrySet()) {
			int k = node.getKey();
			long v = node.getValue();
			if(start <= k && end >= k)
				result += (v - (arr[k] - arr[k-1]));
			if(start == k && end == k)
				result = v;
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int k = Integer.parseInt(temp[2]);
		map = new HashMap<Integer, Long>();
		arr = new long[n+1];
		arr[0] = 0;
		for(int i=1; i<=n; i++)
			arr[i] += (arr[i-1]+Long.parseLong(br.readLine()));
		
		for(int i=0; i<m+k; i++) {
			temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			if(a == 1) change(b, Long.parseLong(temp[2]));
			else bw.append(String.valueOf(sum(b, Integer.parseInt(temp[2])))).append("\n");
		}
		bw.flush();
	}
}