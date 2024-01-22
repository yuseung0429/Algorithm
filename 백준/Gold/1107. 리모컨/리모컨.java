import java.util.*;
import java.io.*;

public class Main {
    static int min;
    static int[] notUsed;
    static String target;
    static int targetNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = br.readLine();
        targetNum = Integer.parseInt(target);
        int n = Integer.parseInt(br.readLine());
        notUsed = new int[10];
        if(n != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n; i++) {
                notUsed[Integer.parseInt(st.nextToken())]++;
            }
        }
        //최솟값 : (시작이 100번째 채널이므로...)
        min = Math.abs(100 - Integer.parseInt(target));

        //처음 0 이 아닌 경우 계산
        for(int i = 0; i < 10; i++) {
            if(notUsed[i] == 1) {
                continue;
            }
            backTracking(1, i);
        }
        System.out.println(min);
    }


    static void backTracking(int depth, Integer in) {

        setMin(in, depth);

        if(depth > target.length() + 1) {
            return;
        }

        for(int i = 0; i < 10; i++) {
            if(notUsed[i] == 1) {
                continue;
            }
            in *= 10;
            in += i;
            backTracking(depth + 1, in);
            in /= 10;

        }
    }

    static void setMin(int min, int depth) {
        Main.min = Math.min(Math.abs(targetNum - min) + depth, Main.min);
    }
}