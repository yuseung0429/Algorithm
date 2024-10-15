import java.io.*;
import java.util.*;

class Main {
	
	public static int solution(int[] arr){
		Arrays.sort(arr);
		
		int posValue = arr[0];
		int posIdx = 0;
		int diffs = 0;
		
		for(int i=0; i<arr.length; i++){
			diffs += Math.abs(posValue - arr[i]);
			if(posValue == arr[i])
				posIdx = i;
		}
			
		while(posIdx < arr.length-1){
			int diff = arr[posIdx+1] - arr[posIdx];
			int posDiffs = diffs + (diff*(posIdx+1)) - (diff*(arr.length-(posIdx+1)));
			if(diffs > posDiffs){
				diffs = posDiffs;
				posValue = arr[posIdx+1];
				posIdx += 1;
				for(int i=posIdx; i<arr.length; i++){
					if(posValue != arr[i])
						break;
					posIdx = i;
				}
				continue;
			} 
			break;
		}
		return arr[posIdx];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String[] temp = br.readLine().split(" ");
		int[] arr = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			arr[i] = Integer.parseInt(temp[i]);
		System.out.println(solution(arr));
	}
}