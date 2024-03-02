import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

public class Main {
	static int globalCnt;
	static TreeSet<Num> set = new TreeSet<Num>();
	static class Num implements Comparable<Num>{
		Num(int value){
			this.value = value;
			this.cnt = globalCnt++;
		}
		int value;
		int cnt;
		@Override
		public int compareTo(Num o) {
			if(this.value == o.value)
				return this.cnt - o.cnt;
			return this.value - o.value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Num cur = new Num(Integer.parseInt(br.readLine()));
		set.add(cur);
		sb.append(cur.value).append("\n");
		for(int i=1; i<n; i++) {
			Num input = new Num(Integer.parseInt(br.readLine()));
			set.add(input);
			if(set.size()%2==0) {
				if(input.value<cur.value)
					cur = set.lower(cur);
			}
			else {
				if(input.value>=cur.value)
					cur = set.higher(cur);
			}
			sb.append(cur.value).append("\n");
		}
		bw.append(sb.toString());
		bw.flush();
	}
}
