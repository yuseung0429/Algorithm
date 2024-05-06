import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	static int n;
	static int k;
	static Queue<Customer> wait;
	static Queue<Customer> counter;
	static ArrayDeque<Integer> seq;
	
	static class Customer{
		Customer(int id, int num, int value){
			this.id = id;
			this.num = num;
			this.value = value;
		}
		int id;
		int num;
		int value;
	}
	
	public static long solution() {
		long result = 0;
		long cnt = 1;
		Customer customer;
		Customer newCustomer;
		while(!counter.isEmpty()) {
			int value = counter.peek().value;
			while(!counter.isEmpty() && counter.peek().value == value) {
				customer = counter.poll();
				seq.add(customer.id);
				newCustomer = wait.poll();
				if(newCustomer == null)
					continue;
				newCustomer.num = customer.num;
				newCustomer.value += value;
				counter.add(newCustomer);
			}
			while(!seq.isEmpty())
				result += seq.pollLast()*cnt++;
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		wait = new ArrayDeque<>(n);
		seq = new ArrayDeque<>();
		counter = new PriorityQueue<>(k, new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				if(o1.value == o2.value)
					return o1.num - o2.num;
				return o1.value - o2.value;
			}
		});
		for(int i=0; i<n; i++) {
			temp = br.readLine().split(" ");
			int number = Integer.parseInt(temp[0]);
			int value = Integer.parseInt(temp[1]);
			if(i<k)
				counter.add(new Customer(number, i, value));
			else
				wait.add(new Customer(number, Integer.MAX_VALUE, value));
		}
		System.out.println(solution());
	}
}
