import java.util.*;
import java.io.*;

class Main{
	
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int result = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++){
			int min = 4;
			int start = arr[i];
			for(int j=1; j<5; j++)
				if(i+j<n && (start+4 >= arr[i+j]))
					min--;
			result = Math.min(result, min);
		}
		System.out.println(result);
	}
}