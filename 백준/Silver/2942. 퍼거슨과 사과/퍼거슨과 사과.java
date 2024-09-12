import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] temp = br.readLine().split(" ");
		
		int r = Integer.parseInt(temp[0]);
		int g = Integer.parseInt(temp[1]);
		
		int n = Math.max((int)Math.sqrt(r), (int)Math.sqrt(g));
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		int s = 0;
		while(++s <= n){
			if(!set.contains(s) && r%s == 0 && g%s == 0)
				sb.append(String.format("%d %d %d\n", s, r/s, g/s));
			set.add(s);
			
			int t = r/s;
			if(!set.contains(t) && r%t == 0 && g%t == 0)
				sb.append(String.format("%d %d %d\n", t, s, g/t));
			set.add(t);
			
			t = g/s;
			if(!set.contains(t) && r%t == 0 && g%t == 0)
				sb.append(String.format("%d %d %d\n", t, r/t, s));
			set.add(t);
		}
		System.out.print(sb);
	}
}