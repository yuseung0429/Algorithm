import java.io.*;
import java.util.*;

class Main {
	
	public static int solution(int[] arr){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(arr[0]);
		
		for(int i=1; i<arr.length; i++){
			int num = arr[i];
			int size = list.size();
			for(int j=size-1; j>=0; j--){
				if(list.get(j) <= num){
					if(j == 0)
						list.set(j, num);
					continue;
				}
				if(j+1 == size)
					list.add(num);
				else
					list.set(j+1, num);
				break;
			}
		}
		
		return arr.length - list.size();
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
