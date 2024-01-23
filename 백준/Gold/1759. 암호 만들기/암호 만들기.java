import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int l;
	static int c;
	static char[] arr;
	static boolean[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void solution() {
		rec(0);
		System.out.print(sb.toString());
	}
	
	public static void rec(int step) {
		if(step == c) {
			char[] result = new char[l];
			int idx = 0;
			for(int i=0; i<c; i++)
				if(selected[i] == true) {
					if(idx == l)
						return;
					result[idx++] = arr[i];
				}
			if(idx == l && check(result)) {
				sb.append(result);
				sb.append("\n");
			}
			return;
		}
		selected[step] = true;
		rec(step+1);
		selected[step] = false;
		rec(step+1);
	}
	
	public static boolean check(char[] str) {
		int nvowel = 0;
		int nconsonant = 0;
		for(char c : str) {
			switch(c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				nvowel++; break;
			default:
				nconsonant++; 
			}
			
			if(nvowel >= 1 && nconsonant >= 2)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		l = Integer.parseInt(temp[0]);
		c = Integer.parseInt(temp[1]);
		selected = new boolean[c];
		arr = br.readLine().replace(" ","").toCharArray();
		Arrays.sort(arr);
		solution();
	}
}