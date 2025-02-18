import java.io.*;
import java.util.*;

class Main {
	
	static int[] arr;
	
	public static void solution(int chance) {
		StringBuilder sb = new StringBuilder();
		
		int i=0;
		
		while(i<arr.length && chance > 0) {
			int maxIdx = getMaxIdx(i, Math.min(i+chance, arr.length-1));
			
			for (int j=maxIdx; j>i; j--) {
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			}
			
			chance -= (maxIdx - i);
			i++;
		}
		
		for(int j=0; j<arr.length; j++) {
			sb.append(arr[j]).append(" ");
		}
		
		System.out.println(sb);
	}
	
	public static int getMaxIdx(int start, int end) {
		int maxIdx = start;
		int maxValue = arr[start];
		for(int i=start; i<=end; i++) {
			if (maxValue < arr[i]) {
				maxValue = arr[i];
				maxIdx = i;
			}
		}
		return maxIdx;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		String[] temp = br.readLine().split(" ");
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		int chance = Integer.parseInt(br.readLine());
		
		solution(chance);
	}
}
