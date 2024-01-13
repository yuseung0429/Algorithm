import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Integer[][] array = new Integer[41][2];
	
	public static void solution(int n) {
		System.out.println(reczero(n)+" "+recone(n));
	}
	
	public static int reczero(int n) {
		if(n==0)
			return 1;
		else if(n <= 1)
			return 0;
		if(array[n][0] != null)
			return array[n][0];
		else
		{
			array[n][0] = reczero(n-1) + reczero(n-2);
			return array[n][0];
		}
	}
	
	public static int recone(int n) {
		if(n==1)
			return 1;
		else if(n < 1)
			return 0;
		if(array[n][1] != null)
			return array[n][1];
		else
		{
			array[n][1] = recone(n-1) + recone(n-2);
			return array[n][1];
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] n = new int[t];
		for(int i=0; i<t; i++)
			n[i] = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++)
			solution(n[i]);
	}
}