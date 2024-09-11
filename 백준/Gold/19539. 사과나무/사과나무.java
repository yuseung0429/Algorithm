import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String[] temp = br.readLine().split(" ");
		int cntOne = 0;
		int cntTwo = 0;
		for(String t : temp){
			int num = Integer.parseInt(t);
			cntOne += num%2;
			cntTwo += num/2;
		}
		
		while(cntTwo>=cntOne) {
			if(cntTwo == cntOne){
				System.out.println("YES");
				return;
			}
			cntTwo--;
			cntOne += 2;
		}
		System.out.println("NO");
	}
}