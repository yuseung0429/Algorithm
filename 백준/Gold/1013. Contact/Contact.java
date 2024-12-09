import java.io.*;
import java.util.*;

class Main {
	
	public static boolean state;
	
	public static String solution(char[] problem) {
		state = false;
		rec(problem, 0);
		if(state) {
			return "YES";
		}
		return "NO";
	}
	
	public static void rec(char[] problem, int idx) {
		if (idx == problem.length) {
			state = true;
		}
		
		if(state) {
			return;
		}
		
		if (problem[idx] == '0') {
			if (idx+1 < problem.length && problem[idx+1] == '1') {
				rec(problem, idx+2);
			}
			return;
		} else {
			if (idx+1 >= problem.length || problem[idx+1] != '0' ||
					idx+2 >= problem.length || problem[idx+2] != '0') {
				return;
			}
			idx+=3;
			
			while (true) {
				if (idx >= problem.length) {
					return;
				}
				if (problem[idx] == '1') {
					break;
				}
				idx++;
			}
			
			while (true) {
				if (idx >= problem.length) {
					rec(problem, idx);
					break;
				}
				if (problem[idx] == '1') {
					rec(problem, ++idx);
					continue;
				}
				return;
			}	
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int i=0; i<t; i++) {
			sb.append(solution(br.readLine().toCharArray())).append("\n");
		}
		System.out.println(sb);
	}
}