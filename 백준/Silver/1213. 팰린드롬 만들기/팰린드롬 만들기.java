import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char temp : br.readLine().toCharArray()) {
			if(map.get(temp) == null)
				map.put(temp, 1);
			else
				map.put(temp, map.get(temp)+1);
		}
		Character[] arr = (Character[])map.keySet().toArray(new Character[1]);
		Arrays.sort(arr);
		for(char temp : arr) {
			int cnt = map.get(temp);
			for(int i=0; i<cnt/2; i++)
				sb.append(temp);
			if(cnt%2 == 0) {
				map.remove(temp);
			}
		}
		if(map.size() > 1)
			System.out.println("I'm Sorry Hansoo");
		else {
			System.out.print(sb.toString());
			if(map.size() == 1)
				System.out.print((char)map.keySet().toArray(new Character[1])[0]);
			System.out.print(sb.reverse().toString());
		}
	}
}