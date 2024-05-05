import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
	static int[] weights;
	static HashSet<Integer> set = new HashSet<Integer>();
	
	public static String solution(int problem) {
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			int vaild = iter.next();
			if(problem == vaild || set.contains(problem + vaild))
				return "Y";	
		}
		return "N";
	}
	
	public static void initSet(int[] weights) {
		set.add(0);
		for(int weight : weights) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			Iterator<Integer> iter = set.iterator();
			while(iter.hasNext()) {
				int number = iter.next();
				list.add(number+weight);
			}
			set.addAll(list);
		}
	}
	
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i]);
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		br.readLine();
		int[] weights = convert(br.readLine().split(" "));
		br.readLine();
		int[] problems = convert(br.readLine().split(" "));
		initSet(weights);
		for(int problem : problems)
			sb.append(solution(problem)+" ");
		System.out.println(sb);
	}
}
