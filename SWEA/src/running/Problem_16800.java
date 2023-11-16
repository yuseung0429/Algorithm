package running;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem_16800 {
	public static long solution(long n)
	{
		return 1;
	}
	public static ArrayList<Long> doFactorization(long n) {
        HashMap<Long, Boolean> primeMap = new HashMap<>();
        ArrayList<Long> result = new ArrayList<>();

        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime(i, primeMap)) {
                while (n % i == 0) {
                    result.add(i);
                    n /= i;
                }
                if (n == 1) {
                    break;
                }
            }
        }
        if (n > 1) {
            result.add(n);
        }
        return result;
    }

    public static boolean isPrime(long n, HashMap<Long, Boolean> primeMap) {
        if (n < 2) {
            return false;
        }

        if (primeMap.containsKey(n)) {
            return primeMap.get(n);
        }

        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                primeMap.put(n, false);
                return false;
            }
        }
        primeMap.put(n, true);
        return true;
    }
    
    public static long[] getMinPair(ArrayList<Long> decompos)
    {
    	long x = 0;
    	long y = 0;
    	for(int i=1; i<=decompos.size()/2; i++)
    	{
    		
    	}
    	
    	
    }
	public static void main(String[] args)
	{
		long value = Long.parseLong("18991325453139");
		ArrayList<Long> list = doFactorization(value);
		for(long i : list)
			System.out.println(i);
//		Scanner in = new Scanner(System.in);
//		int t = Integer.parseInt(in.nextLine());
//		long[] n = new long[t];
//		for(int i=0; i<t; i++)
//			n[i] = Long.parseLong(in.nextLine());
//		for(int i=0; i<t; i++)
//			System.out.println("# "+(i+1)+" " + solution(n[i]));
//		in.close();
	}
}
