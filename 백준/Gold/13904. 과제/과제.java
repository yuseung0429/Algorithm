import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static class Problem implements Comparable<Problem>{
		public Problem(int deadLine, int score) {
			this.deadLine = deadLine;
			this.score = score;
		}
		int deadLine;
		int score;
		
		@Override
		public int compareTo(Problem o) {
			if(this.deadLine == o.deadLine)
				return Integer.compare(o.score, this.score);
			return Integer.compare(this.deadLine, o.deadLine);
		}
	}
	
	static PriorityQueue<Problem> waitQueue = new PriorityQueue<>();
	static PriorityQueue<Problem> selectQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.score, o2.score));
	
	public static int solution() {
		while(!waitQueue.isEmpty()) {
			Problem problem = waitQueue.poll();
			
			if(selectQueue.size() < problem.deadLine) {
				selectQueue.add(problem);
				continue;
			}
			
			if(selectQueue.peek().score <= problem.score) {
				selectQueue.poll();
				selectQueue.add(problem);
			}
		}
		
		int result = 0;
		
		while(!selectQueue.isEmpty())
			result += selectQueue.poll().score;
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			waitQueue.add(new Problem(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
		}
		System.out.println(solution());
	}
}
