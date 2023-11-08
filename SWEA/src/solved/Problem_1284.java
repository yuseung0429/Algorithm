package solved;

import java.util.Scanner;

public class Problem_1284 {
    public static int solution(int p, int q, int r, int s, int w) {
        int priceA = p * w;
        int priceB = (w > r) ? q+(w-r)*s : q;
        return Math.min(priceA, priceB);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        int[] p = new int[t];
        int[] q = new int[t];
        int[] r = new int[t];
        int[] s = new int[t];
        int[] w = new int[t];
        for (int i = 0; i < t; i++) {
            String[] temp = in.nextLine().split(" ");
            p[i] = Integer.parseInt(temp[0]);
            q[i] = Integer.parseInt(temp[1]);
            r[i] = Integer.parseInt(temp[2]);
            s[i] = Integer.parseInt(temp[3]);
            w[i] = Integer.parseInt(temp[4]);
        }
        for (int i = 0; i < t; i++) {
            int result = solution(p[i], q[i], r[i], s[i], w[i]);
            System.out.println("#" + (i + 1) + " " + result);
        }
        in.close();
    }
}