import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		int count=0;
		int a = 1;
		while(a <= n)
			a *= 2;
		while(a != 0) {
			a /= 2;
			if(a > n || a==0)
				continue;
			n = n-a;
			list.add(a);
		}
		list.sort(null);
		while(list.size() > k) {
			if((int)list.get(0) == (int)list.get(1)) {
				list.set(0, list.get(0)*2);
				list.remove(1);
			}
			else {
				int add = list.get(1) - list.get(0);
				count += add;
				list.set(0, list.get(0)+add);
			}
		}
		System.out.println(count);
	}
}
