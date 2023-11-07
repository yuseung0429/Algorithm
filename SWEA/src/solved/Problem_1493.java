package solved;

import java.util.Scanner;
 
public class Problem_1493 {
    public static int solution(int a, int b)
    {
        int[] p1 = ampersand(a);
        int[] p2 = ampersand(b);
        return hash(p1[0]+p2[0], p1[1]+p2[1]);
    }
    public static int[] ampersand(int n)    
    {
        int start = 1;
        int step = 1;
        int[] result = new int[2];
        while(true)
        {
            if((start <= n) && (start+step > n))
                break;
            else
            {
                start += step;
                step += 1;
            }   
        }
        result[0] = 1 + (n-start);
        result[1] = step - (n-start);
        return result;
    }
    public static int hash(int x, int y)
    {   
        int step = y + (x-1);
        int num = 1;
        for(int i=0; i<step; i++)
            num += i;
        return num + (x-1);
    }
     
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        int arg1[] = new int[t];
        int arg2[] = new int[t];
        for(int i=0; i<t; i++)
        {
            String[] temp = in.nextLine().split(" ");
            arg1[i] = Integer.parseInt(temp[0]);
            arg2[i] = Integer.parseInt(temp[1]);
        }
        for(int i=0; i<t; i++)
            System.out.println("#"+(i+1)+ " " +solution(arg1[i], arg2[i]));
        in.close();
    }
}