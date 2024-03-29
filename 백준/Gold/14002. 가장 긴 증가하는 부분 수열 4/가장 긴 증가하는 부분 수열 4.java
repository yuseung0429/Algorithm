import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int n;
	static int[][] arr;
	
	public static void solution() {
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for(int i=0; i<arr.length; i++) {
			int idx = binarySearch(list, arr[i][0]);
			if(idx == list.size())
				list.add(arr[i][0]);
			else if(list.get(idx)>arr[i][0])
				list.set(idx, arr[i][0]);
			arr[i][1] = idx;
		}
		System.out.println(list.size());
		int findNum = list.size()-1;
		
		for(int i=arr.length-1; i>=0; i--) {
			if(findNum < 0)
				break;
			if(arr[i][1] == findNum) {
				queue.add(arr[i][0]);
				findNum--;
			}
		}
		while(!queue.isEmpty())
			sb.append(queue.pollLast()).append(" ");
		System.out.println(sb.toString());
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
		arr = new int[n][2];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<input.length; i++)
			arr[i][0] = Integer.parseInt(input[i]);
		solution();
	}
}
