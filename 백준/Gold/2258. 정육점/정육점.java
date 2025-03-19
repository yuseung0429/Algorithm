import java.io.*;
import java.util.*;

class Main {
	
	static int[][] arr;

	public static int solution(int n, int m) {
		Arrays.sort(arr, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return Integer.compare(o2[0], o1[0]);
			}
			return Integer.compare(o1[1], o2[1]);
		});
		
		int currentPrice = 0;
		int currentPriceSum = 0;
		int weightSum = 0;
		
		int minPrice = Integer.MAX_VALUE;
		boolean isSuccess = false;
		
		for (int i=0; i<n; i++) {
			int[] meat = arr[i];
			weightSum += meat[0];
			if (meat[1] > currentPrice) {
				currentPrice = meat[1];
				currentPriceSum = meat[1];
			} else if (meat[1] == currentPrice) {
				currentPriceSum += meat[1];
			} 

			if (weightSum >= m) {
				isSuccess = true;
				minPrice = Math.min(minPrice, currentPriceSum);
			}
		}
		
		return isSuccess ? minPrice : -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		arr = new int[n][2];
		
		for (int i=0; i<n; i++) {
			temp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(temp[0]);
			arr[i][1] = Integer.parseInt(temp[1]);
		}
		
		System.out.println(solution(n, m));
	}
}