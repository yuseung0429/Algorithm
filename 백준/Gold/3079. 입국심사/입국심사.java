import java.io.*;
import java.util.*;

class Main{
	
	static int n;
	static int m;
	static int max = Integer.MIN_VALUE;
	static int[] arr;
	
	public static long solution(){
		long left = 1;
		long right =(long)max * m;
		long result = 0;
		
		while(left <= right){
			long mid = (left + right) / 2;
			long sum = 0;
			for(long num : arr){
				sum += (mid/num);
				if(sum >= m) 
					break;
			}
			if(sum >= m){
				result = mid;
				right = mid - 1;
			}
			else
				left = mid + 1;
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}
		System.out.println(solution());
	}
}