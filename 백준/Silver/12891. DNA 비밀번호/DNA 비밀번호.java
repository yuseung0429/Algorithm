import java.util.*;
import java.io.*;

class Main {
	
	public static int s;
	public static int p;
	public static char[] str;
	
	public static final int A = 0;
	public static final int C = 1;
	public static final int G = 2;
	public static final int T = 3;
	
	public static int[] minCnt;
	public static int[] posCnt;
	
	public static int solution() {
		int vaildCnt = 0;
		
		for(int i=0; i<p; i++) {
			switch(str[i]) {
				case 'A': posCnt[A]++; break;
				case 'C': posCnt[C]++; break;
				case 'G': posCnt[G]++; break;
				case 'T': posCnt[T]++; break;
			}
		}
		int last = 0;
		int next = p;
		
		while(true) {
			if(isVaild()) {
				vaildCnt++;
			}
			
			if(next==s) {
				return vaildCnt;
			}
						
			switch(str[last++]) {
				case 'A': posCnt[A]--; break;
				case 'C': posCnt[C]--; break;
				case 'G': posCnt[G]--; break;
				case 'T': posCnt[T]--; break;
			}
			
			switch(str[next++]) {
				case 'A': posCnt[A]++; break;
				case 'C': posCnt[C]++; break;
				case 'G': posCnt[G]++; break;
				case 'T': posCnt[T]++; break;
			}
		}
	}
	
	public static boolean isVaild() {
		return (posCnt[A] >= minCnt[A]) && (posCnt[C] >= minCnt[C]) && (posCnt[G] >= minCnt[G]) && (posCnt[T] >= minCnt[T]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		s = Integer.parseInt(temp[0]);
		p = Integer.parseInt(temp[1]);
		str = br.readLine().toCharArray();
		temp = br.readLine().split(" ");
		minCnt = new int[4];
		posCnt = new int[4];
		
		minCnt[A] = Integer.parseInt(temp[0]);
		minCnt[C] = Integer.parseInt(temp[1]);
		minCnt[G] = Integer.parseInt(temp[2]);
		minCnt[T] = Integer.parseInt(temp[3]);
	
		System.out.println(solution());
	}
}