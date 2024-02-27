import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] convert(String[] temp) {
		int[] result = new int[temp.length];
		for(int i=0; i<temp.length; i++)
			result[i] = Integer.parseInt(temp[i]);
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int s = Integer.parseInt(temp[1]);
		
		int[] numbers = convert(br.readLine().split(" "));
		int maxLength = 0;
		int sum = 0;
		int front = 0;
		int back = 0;
		while(sum < s) {
			if(front == n) {
				System.out.println(0);
				return;
			}
			sum += numbers[front++];
		}
		maxLength = (front - back);
		
		while(back <= front) {
			if(sum < s) {
				if(front == n)
					break;
				sum += numbers[front++];
			}
			if(sum >= s) {
				maxLength = Math.min((front-back), maxLength);
				if(back == n) {
					System.out.println(maxLength);
					return;
				}
				sum -= numbers[back++];
			}
		}
		System.out.println(maxLength);
	}
}