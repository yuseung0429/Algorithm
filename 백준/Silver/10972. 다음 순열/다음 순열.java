import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void solution(int[] arr) {
		StringBuilder sb = new StringBuilder();
		int pos = -1;
		for(int i = arr.length-1; i>0; i--)
			if(arr[i-1] < arr[i]) {
				pos = i-1;
				break;
			}
		if(pos == -1) {
			System.out.print(-1);
			return;
		}
		int min_idx = 0;
		int interval = Integer.MAX_VALUE;
		for(int j = pos+1; j<arr.length; j++)
			if(arr[j] > arr[pos])
				if(arr[j]-arr[pos] < interval) {
					interval = arr[j]-arr[pos];
					min_idx = j;
				}
		int temp = arr[pos];
		arr[pos] = arr[min_idx];
		arr[min_idx] = temp;
		
		for(int i=0; i<=pos; i++) {
			sb.append(arr[i]);
			sb.append(" ");
		}
		
		for(int j=arr.length-1; j>pos; j--) {
			sb.append(arr[j]);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i]);
		return result;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		int[] arr = convert(br.readLine().split(" "));
		solution(arr);
	}
}