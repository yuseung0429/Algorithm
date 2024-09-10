import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		String[] temp;
		for(int i=0; i<n; i++){
			temp = br.readLine().split(" ");
			Integer year = Integer.parseInt(temp[3]);
			Integer month = Integer.parseInt(temp[2]);
			Integer day = Integer.parseInt(temp[1]);
			map.put(Integer.parseInt(String.format("%04d%02d%02d", year, month, day)), temp[0]);
		}
		System.out.println(map.get(map.lastKey()));
		System.out.print(map.get(map.firstKey()));
	}
}