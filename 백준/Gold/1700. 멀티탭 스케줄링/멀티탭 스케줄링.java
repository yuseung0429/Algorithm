import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	static int n;
	static int k;
	
	static int[] seq;
	
	static Set<Integer> set = new HashSet<>();
	
	public static int solution() {
		int change = 0;
		
		for(int i=0; i<seq.length; i++) {
			int target = seq[i];
			
			if(set.contains(target))
				continue;
				
			if(set.size() < n) { 
				set.add(target);
				continue;
			}
			
			int max = -1;
			int maxIdx = -1;
			for(int element : set) {
				int j=i+1;
				for(; j<seq.length; j++) {
					if(element != seq[j])
						continue;
					if(maxIdx < j) {
						max = element;
						maxIdx = j;
					}
					break;
				}
				if(j==seq.length) {
					max = element;
					break;
				}
			}
			set.remove(max);
			set.add(target);
			change++;
		}
		return change;
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i])-1;
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		seq = convert(br.readLine().split(" "));
		System.out.println(solution());
	}
}
