import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static int solution(ArrayList<Integer> a, ArrayList<Integer> b) {
		a.sort(null);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i : b)
			temp.add(i);
		int sum = 0;
		for(int j : a) {
			int t = getMax(temp);
			sum += j*t;
			temp.remove((Integer)t);
		}
		return sum;
	}
	
	public static int getMax(ArrayList<Integer> temp) {
		int max = 0;
		for(int a : temp)
			if(max < a)
				max = a;
		return max;
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
		ArrayList<Integer> a = convert(br.readLine().split(" "));
		ArrayList<Integer> b = convert(br.readLine().split(" "));
		System.out.println(solution(a, b));
	}
}
