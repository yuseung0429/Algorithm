import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] paper = new boolean[100][100];
		int n = Integer.parseInt(br.readLine());
		int area = 0;
		String[] temp = null;
		for(int i=0; i<n; i++) {
			temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = 100-(Integer.parseInt(temp[1])+10);
			for(int j=0; j<10; j++)
				for(int k=0; k<10; k++)
					paper[y+j][x+k] = true;
		}
		for(int i=0; i<100; i++)
			for(int j=0; j<100; j++)
				if(paper[i][j] == true)
					area++;
		System.out.println(area);
	}
}