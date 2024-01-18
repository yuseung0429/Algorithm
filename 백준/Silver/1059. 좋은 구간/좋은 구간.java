import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static int solution(ArrayList<Integer> arr, int n) {
		arr.sort(null);
		arr.add(0, 0);
		for(int i=0; i<arr.size(); i++)
			if(arr.get(i).intValue() == n || arr.get(i+1).intValue() == n)
				return 0;
			else if(arr.get(i).intValue() < n && arr.get(i+1).intValue() > n) {
				int nleft = n - arr.get(i)-1;
				int nright = arr.get(i+1) - n-1;
				return nleft*nright + nleft + nright;
			}
		return 0;
	}
	public static ArrayList<Integer> convert(String[] temp) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<temp.length; i++)
			result.add(Integer.parseInt(temp[i]));
		return result;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		ArrayList<Integer> arr = convert(br.readLine().split(" "));
		int n = Integer.parseInt(br.readLine());
		System.out.println(solution(arr, n));
	}
}