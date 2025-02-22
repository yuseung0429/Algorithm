import java.io.*;
import java.util.*;

class Main {

	public static int solution(int[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>();
	
		for (int num : arr) {
			if (list.isEmpty() || list.get(list.size()-1) < num) {
				list.add(num);
				continue;
			}
			
			int idx = binarySearch(list, num);
			list.set(idx, num);
		}
		
		return list.size();
	}
	
	public static int binarySearch(ArrayList<Integer> list, int num) {
		int left = 0;
		int right = list.size()-1;
		
		while(left <= right) {
			int mid = (left + right)/2;
			int value = list.get(mid);
			if (num > value) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] temp = br.readLine().split(" ");
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		System.out.println(solution(arr));
	}
}