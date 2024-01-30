import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void solution(boolean[] arr, boolean[] gender, int[] n) {
		int size = arr.length;
		for(int i=0; i<gender.length; i++) {
			if(gender[i])
				for(int j=n[i]; j<size; j+=n[i])
					arr[j] = !arr[j];
			else {
				arr[n[i]] = !arr[n[i]];
				for(int k=1; n[i]+k<size && n[i]-k>0; k++) {
					if(arr[n[i]+k] == arr[n[i]-k]) {
						arr[n[i]+k] = !arr[n[i]+k];
						arr[n[i]-k] = !arr[n[i]-k];
					}
					else
						break;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<size; i++) {
			sb.append(arr[i] == true ? 1 : 0);
			if(i%20 != 0)
				sb.append(" ");
			else
				sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean[] convert(String[] temp) {
		boolean[] result = new boolean[temp.length+1];
		for(int i=0; i<temp.length; i++)
			result[i+1] = temp[i].equals("1") ? true : false;
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		boolean[] arr = convert(br.readLine().split(" "));
		int f = Integer.parseInt(br.readLine());
		boolean[] gender = new boolean[f];
		int[] n = new int[f];
		for(int i=0; i<f; i++) {
			String[] temp = br.readLine().split(" ");
			gender[i] = (Integer.parseInt(temp[0]) == 1) ? true : false;
			n[i] = Integer.parseInt(temp[1]);
		}
		solution(arr, gender, n);
	}
}