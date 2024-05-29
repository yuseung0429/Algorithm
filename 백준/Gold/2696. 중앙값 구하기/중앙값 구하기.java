import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void solution(int n, ArrayList<Integer> list) {
		Queue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		Queue<Integer> minQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
		sb.append(n/2+1).append("\n");
		for(int i=0; i<n; i++) {
			int value = list.get(i);
			if(maxQueue.isEmpty()) {
				maxQueue.add(value);
			}else {
				if(maxQueue.peek() < value) {
					minQueue.add(value);
					if(maxQueue.size() < minQueue.size())
						maxQueue.add(minQueue.poll());
				} else {
					maxQueue.add(value);
					if(maxQueue.size()-1 > minQueue.size())
						minQueue.add(maxQueue.poll());
				}
			}
			if(i%2==0) {
				sb.append(maxQueue.peek()).append(" ");
				if(i!=0 && (i+2)%20 == 0)
					sb.append("\n");
			}
				
		}
		sb.append("\n");
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			for(int j=0; j<=(n-1)/10; j++) {
				String[] temp = br.readLine().split(" ");
				for(int k=0; k<temp.length; k++)
					list.add(Integer.parseInt(temp[k]));
			}
			solution(n, list);
		}
		System.out.println(sb);
	}
}
