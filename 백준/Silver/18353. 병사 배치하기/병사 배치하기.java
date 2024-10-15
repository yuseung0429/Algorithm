import java.io.*;
import java.util.*;

class Main {
	
	public static ArrayList<Integer> list;
	
	public static int solution(int[] arr) {
		list = new ArrayList<Integer>();
		list.add(arr[0]);
		
		for(int i=1; i<arr.length; i++) {
			int idx = binarySearch(arr[i]);
			
			if(idx == list.size())
				list.add(arr[i]);
			
			if(list.get(idx) < arr[i])
				list.set(idx, arr[i]);
		}
		return arr.length - list.size();
	}
	
	public static int binarySearch(int num){
		int left = 0;
		int right = list.size()-1;
	
		while(left <= right) {
			int mid = (left+right)/2;
			int value = list.get(mid);
			if(value == num) 
				return mid;
			if(value < num)
				right = mid-1;
			else
				left = mid+1;
		}
		return left;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		
		String[] input = br.readLine().split(" ");
		int[] arr = new int[input.length];
		for(int i=0; i<input.length; i++)
			arr[i] = Integer.parseInt(input[i]);
		
		System.out.println(solution(arr));
	}
}
