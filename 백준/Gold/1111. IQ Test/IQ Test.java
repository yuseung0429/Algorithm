import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int[] arr;
	
	public static void solution() {
		switch(n){
			case 1: {
				System.out.println("A"); 
				return;
			}
			case 2: {
				if (arr[0] == arr[1]) {
					System.out.println(arr[0]);
					return;
				}
				System.out.println("A");
				return;
			}
			default: {
				int diff = arr[2] - arr[1];
				int coef = arr[1] - arr[0];
				
				if (coef == 0) {
					for (int i=0; i<n; i++) {
						if (arr[0] != arr[i]) {
							System.out.println("B");
							return;
						}
					}
					System.out.println(arr[0]);
					return;
				}
				
				if (diff == 0) {
					for(int i=1; i<n; i++) {
						if (arr[1] != arr[i]) {
							System.out.println("B");
							return;
						}
					}
					System.out.println(arr[1]);
					return;
				}			
				
				if ((diff % coef) != 0) {
					System.out.println("B");
					return;
				}
			
				int a = diff / coef;
				int b = arr[1] - (arr[0] * a);
				
				for (int i=0; i<n-2; i++) {
					diff = arr[i+2] - arr[i+1];
					coef = arr[i+1] - arr[i];
					if (coef == 0 || diff % coef != 0) {
						System.out.println("B");
						return;
					}
					
					int localA = diff / coef;
					int localB = arr[i+1] - (arr[i] * a);
					if (localA != a || localB != b) {
						System.out.println("B");
						return;
					}
				}
				System.out.println(arr[arr.length-1]*a + b);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		String[] temp = br.readLine().split(" ");
		arr = new int[n];
		
		for (int i=0; i<n; i++)
			arr[i] = Integer.parseInt(temp[i]);
		
		solution();
	}
}