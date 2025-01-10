import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int m;
	static int k;
	static int[][] foods;
	static int[][] matrix;
	static ArrayList<Integer>[][] trees;
	
	static int[] dy = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dx = new int[]{-1, 0, 1, -1 ,1, -1, 0, 1};
	
	public static int solution() {
		int year = 0;
		
		while (year++ < k) {
			springAndSummer();
			fall();
			winter();
		}
		
		int count = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (trees[i][j].isEmpty()) {
					continue;
				}
				count += trees[i][j].size();
			}
		}
		return count;
	}
	
	public static void springAndSummer() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				ArrayList<Integer> alive = new ArrayList<Integer>();
				ArrayList<Integer> list = trees[i][j];
				int k = list.size()-1;
				for (; k>=0; k--) {
					if(foods[i][j] - list.get(k) < 0) {
						break;
					}
					foods[i][j] -= list.get(k);
					alive.add(list.get(k)+1);
				}
				for (; k>=0; k--) {
					foods[i][j] += list.get(k)/2;
				}
				Collections.reverse(alive);
				trees[i][j] = alive;
			}
		}
	}
	
	public static void fall() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (trees[i][j].isEmpty()) {
					continue;
				}
				for(int year : trees[i][j]) {
					if (year % 5 != 0) {
						continue;
					}
					for (int k=0; k<8; k++) {
						int y = i + dy[k];
						int x = j + dx[k];
						if(y<0 || y>=n || x<0 || x>=n) {
							continue;
						}
						trees[y][x].add(1);
					}
				}
			}
		}
	}
	
	public static void winter() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				foods[i][j] += matrix[i][j];
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		k = Integer.parseInt(temp[2]);
		
		matrix = new int[n][n];
		foods = new int[n][n];
		trees = new ArrayList[n][n];
		
		for (int i=0; i<n; i++) {
			temp = br.readLine().split(" ");
			for (int j=0; j<n; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
				trees[i][j] = new ArrayList<Integer>();
				foods[i][j] = 5;
			}
		}
		
		for (int i=0; i<m; i++) {
			temp = br.readLine().split(" ");
			int y = Integer.parseInt(temp[0])-1;
			int x = Integer.parseInt(temp[1])-1;
			int year = Integer.parseInt(temp[2]);
			trees[y][x].add(year);
		}
		
		System.out.println(solution());
	}
}