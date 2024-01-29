import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static String[] strs = new String[7];
	public static int n;
	public static void rec(int step) {
		if(step == 0) {
			for(int i=0; i<n-step; i++)
				sb.append("____");
			sb.append(strs[1]);
			for(int i=0; i<n-step; i++)
				sb.append("____");
			sb.append(strs[5]);
			for(int i=0; i<n-step; i++)
				sb.append("____");
			sb.append(strs[6]);
			return;
		}
		for(int i=0; i<n-step; i++)
			sb.append("____");
		sb.append(strs[1]);
		for(int i=0; i<n-step; i++)
			sb.append("____");
		sb.append(strs[2]);
		for(int i=0; i<n-step; i++)
			sb.append("____");
		sb.append(strs[3]);
		for(int i=0; i<n-step; i++)
			sb.append("____");
		sb.append(strs[4]);
		rec(step-1);
		for(int i=0; i<n-step; i++)
			sb.append("____");
		sb.append(strs[6]);
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		strs[0] = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
		strs[1] = "\"재귀함수가 뭔가요?\"\n";
		strs[2] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
		strs[3] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
		strs[4] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
		strs[5] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
		strs[6] = "라고 답변하였지.\n";
		sb.append(strs[0]);
		rec(n);
		System.out.println(sb.toString());
	}
}
