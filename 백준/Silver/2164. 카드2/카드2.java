import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<n+1; i++)
			queue.add(i);
		boolean flag = true;
		while(queue.size() != 1) {
			if(flag)
				queue.poll();
			else {
				queue.add(queue.poll());
			}
			flag = !flag;
		}
		System.out.println(queue.poll());
	}
}