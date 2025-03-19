import java.io.*;
import java.util.*;

class Main {
	
	static int[][] people;
	
	public static void solution() {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(people, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		
		PriorityQueue<int[]> usePeople = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[0], o2[0]));
		PriorityQueue<Integer> availableComputers = new PriorityQueue<Integer>();
		
		ArrayList<Integer> computers = new ArrayList<Integer>();

		for (int i=0; i<people.length; i++) {
			int[] person = people[i];
			
			while (!usePeople.isEmpty() && usePeople.peek()[0] < person[0]) {
				int[] exitPerson = usePeople.poll();
				availableComputers.add(exitPerson[1]);
			}
			
			if (usePeople.size() == computers.size()) {
				computers.add(0);
				availableComputers.add(computers.size()-1);
			}
			
			int useComputer = availableComputers.poll();
			computers.set(useComputer, computers.get(useComputer)+1);
			usePeople.add(new int[] {person[1], useComputer});
		}
		
		sb.append(computers.size()).append('\n');
		
		for (int computer : computers) {
			sb.append(computer).append(' ');
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		people = new int[n][2];
		
		for (int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			people[i][0] = Integer.parseInt(temp[0]);
			people[i][1] = Integer.parseInt(temp[1]);
		}
		
		solution();
	}
}