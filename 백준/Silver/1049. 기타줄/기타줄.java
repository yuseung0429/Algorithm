import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int solution(int n, int[] setprice, int[] eachprice) {
		int cost = 0;
		int[] ceachprice1 = eachprice.clone();
		for(int i=0; i<eachprice.length; i++)
			ceachprice1[i] *= 6;
		cost += Math.min(setprice[minidx(setprice)], ceachprice1[minidx(ceachprice1)]) * (n/6);
		int remain = n%6;
		int[] ceachprice2 = eachprice.clone();
		for(int i=0; i<eachprice.length; i++)
			ceachprice2[i] *= remain;
		cost += Math.min(setprice[minidx(setprice)], ceachprice2[minidx(ceachprice2)]);
		return cost;
	}
	
	public static int minidx(int[] price) {
		int min = price[0];
		int idx = 0;
		for(int i=1; i<price.length; i++) {
			if(price[i] < min) {
				min = price[i];
				idx = i;
			}
		}
		return idx;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int nbrand = Integer.parseInt(temp[1]);
		int[] setprice = new int[nbrand];
		int[] eachprice = new int[nbrand];
		for(int i=0; i<nbrand; i++) {
			temp = br.readLine().split(" ");
			setprice[i] = Integer.parseInt(temp[0]);
			eachprice[i] = Integer.parseInt(temp[1]);		
		}
		System.out.println(solution(n, setprice, eachprice));
	}
}