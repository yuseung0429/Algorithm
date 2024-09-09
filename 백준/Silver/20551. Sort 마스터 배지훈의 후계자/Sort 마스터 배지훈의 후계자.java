import java.io.*;
import java.util.*;

class Main{
	
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] temp = br.readLine().split(" ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap();
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		for(int i=0; i<n; i++)
			list.add(Integer.parseInt(br.readLine()));	
		list.sort(null);
		
		Integer memo = Integer.MIN_VALUE;
		int cnt = -1;
		for(Integer n : list){
			cnt++;
			if(memo >= n)
				continue;
			map.put(n, cnt);
			memo = n;
		}
		
		for(int i=0; i<m; i++){
			Integer n = Integer.parseInt(br.readLine());
			n = map.get(n);
			sb.append(n!=null?n:-1).append("\n");
		}
		
		System.out.print(sb);
	}
}
