import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int n;
	static int[] arr;
	
	public static int solution() {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			int idx = binarySearch(list, arr[i]);
			if(idx == list.size())
				list.add(arr[i]);
			else if(list.get(idx)>arr[i])
				list.set(idx, arr[i]);
		}
		return list.size();
	}
	
	public static int binarySearch(List<Integer> list, int value) {
		int start = 0;
		int end = list.size()-1;
		while(start<=end) {
			int mid = (end + start)/2;
			int target = list.get(mid).intValue();
			if(target == value) 
				return mid;
			else if(target > value) 
				end = mid-1;
			else 
				start = mid+1;
		}
		return start;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<input.length; i++)
			arr[i] = Integer.parseInt(input[i]);
		System.out.println(solution());
	}
}
