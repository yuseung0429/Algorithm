import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		boolean flag = false;
		
		StringBuilder sb = new StringBuilder();
		
		for(char a : str.toCharArray()) {
			switch(a) {
			case '<' : {
				flag = true; 
				sb.append('<');
				break;
			}
			case '>' : {
				flag = false;
				sb.append('>');
				bw.append(sb.toString());
				sb.setLength(0);
				break;
			}
			case ' ' : {
				if(flag == true) 
					sb.append(' ');
				else {
					bw.append(sb.toString());
					sb.setLength(0);
					bw.append(' ');
				}
				break;
			}
			default :
				if(flag == true) 
					sb.append(a);
				else
					sb.insert(0,a);
			}
		}
		bw.append(sb.toString());
		bw.flush();
	}
}