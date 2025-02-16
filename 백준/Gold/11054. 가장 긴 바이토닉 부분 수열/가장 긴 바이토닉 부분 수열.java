import java.io.*;
import java.util.*;

class Main {
	
	public static int solution(int n, int[] arr) {
		int[][] lengths = new int[2][n];
		int maxLength = Integer.MIN_VALUE;	
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(arr[0]);
		lengths[0][0] = 1;
		
		for (int i=1; i<n; i++) {
			int idx = binarySearch(list, arr[i]);
			
			if(idx == list.size()) {
				list.add(arr[i]);
			} else {
				list.set(idx, arr[i]);
			}
			lengths[0][i] = list.size();
		}
		
		list = new ArrayList<Integer>();
		list.add(arr[n-1]);
		lengths[1][n-1] = 1;
		
		for (int i=n-2; i>=0; i--) {
			int idx = binarySearch(list, arr[i]);
			
			if(idx == list.size()) {
				list.add(arr[i]);
			} else {
				list.set(idx, arr[i]);
			}
			lengths[1][i] = list.size();
		}	
		
		for (int i=0; i<n; i++) {	
			maxLength = Math.max(maxLength, lengths[0][i] + lengths[1][i]);
		}
		
		return maxLength-1;
	}
	
	public static int binarySearch(ArrayList<Integer> list, int value) {
		int left = 0;
		int right = list.size()-1;
		
		while (left <= right) {
			int mid = (left + right)/2;
			int midValue = list.get(mid);
			
			if (value == midValue) {
				return mid;
			}
			
			if (value > midValue) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}	
		return left;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		String[] temp = br.readLine().split(" ");
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		System.out.println(solution(n, arr));
	}
}