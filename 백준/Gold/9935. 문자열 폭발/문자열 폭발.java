import java.io.*;
import java.util.*;

class Main {
    public static void solution(char[] str, char[] boomStr) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> stack = new ArrayList<>();

        for (char c : str) {
            stack.add(c);

            if (stack.size() >= boomStr.length) {
                boolean flag = true;
                for (int j=0; j<boomStr.length; j++) {
                    if (stack.get(stack.size() - boomStr.length + j) != boomStr[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j=0; j<boomStr.length; j++) {
                        stack.remove(stack.size()-1);
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        } 
        
        for (char c : stack) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br.readLine().toCharArray(), br.readLine().toCharArray());
    }
}