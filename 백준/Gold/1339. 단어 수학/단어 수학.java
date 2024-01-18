import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
	
	public static int solution(String[] strs) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(String temp : strs) {
			int length = temp.length()-1;
			for(Character a : temp.toCharArray()) {
				int value = (int) Math.pow(10, length--);
				if(map.get(a) == null)
					map.put(a, value);
				else
					map.put(a, map.get(a)+value);
			}
		}
		List<Character> keys = new ArrayList<Character>(map.keySet());
		keys.sort((o1, o2) -> Integer.compare(map.get(o2), map.get(o1)));
		
		int ret = 0;
		int init = 9;
		for(char temp : keys)
			ret += map.get(temp) * init--;
		
		return ret;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] strs = new String[n];
		for(int i=0; i<n; i++)
			strs[i] = br.readLine();
		System.out.println(solution(strs));
	}
}