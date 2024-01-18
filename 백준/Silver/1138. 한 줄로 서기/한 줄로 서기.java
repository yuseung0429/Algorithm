import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void solution(int[] arr) throws IOException {
		int[] result = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			int j = arr[i];
			int cnt = -1;
			for(int k=0; k<result.length; k++) {
				if(result[k] == 0)
					cnt++;
				if(cnt == j) {
					result[k] = i+1;
					break;
				}
			}
		}
		for(int a : result)
			bw.write(a+" ");
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
		bw.flush();
	}
}