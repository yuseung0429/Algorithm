import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, HashSet<String>> map = new HashMap<Integer, HashSet<String>>();
		
		for(int i=0; i<n; i++) {
			String temp = br.readLine();
			HashSet<String> set = map.get(temp.length());
			if(set == null) {
				HashSet<String> newset = new HashSet<String>();
				newset.add(temp);
				map.put(temp.length(), newset);
			}
			else
				set.add(temp);
		}
		
		Integer[] arr = (Integer[])map.keySet().toArray(new Integer[0]);
		Arrays.sort(arr);
		
		for(Integer i : arr) {
			String[] temp = (String[]) map.get(i).toArray(new String[0]);
			Arrays.sort(temp);
			for(String str : temp) {
				sb.append(str);
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}