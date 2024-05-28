import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	static Queue<Problem> list = new PriorityQueue<>();
	static Queue<Problem> done = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.count, o2.count));
	
	static class Problem implements Comparable<Problem>{
		public Problem(int deadline, int count) {
			this.deadline = deadline;
			this.count = count;
		}
		
		int deadline;
		int count;
		
		@Override
		public int compareTo(Problem o) {
			if(this.deadline == o.deadline)
				return Integer.compare(o.count, this.count);
			return Integer.compare(this.deadline, o.deadline);
		}
	}
    
	public static void solution() {
		int time = 1;
		while(!list.isEmpty()) {
			Problem problem = list.poll();
			if(time <= problem.deadline) {
				done.add(problem);
				time++;
			} 
			else {
				Problem minReturn = done.peek();
				if(minReturn.count < problem.count) {
					done.poll();
					done.add(problem);
				}
			}
		}
		int result = 0;
		while(!done.isEmpty())
			result += done.poll().count;
		System.out.println(result);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			String[] temp = br.readLine().split(" ");
			int deadline = Integer.parseInt(temp[0]);
			int count = Integer.parseInt(temp[1]);
			Problem problem = new Problem(deadline, count);
			list.add(problem);
		}
		solution();
	}
}
