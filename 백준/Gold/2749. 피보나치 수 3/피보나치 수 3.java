import java.io.*;
import java.util.*;

class Main {
    public static long value = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine())%1500000;
        System.out.println(sum(n));
    }

    public static long sum(long n) {
        if (n <= 1) {
            return n;
        }

       long a=0;
       long b=1;
       long result=0;

        for (int i = 2; i <= n; i++) {
        	 result = (a + b) % value;
             a = b;
             b = result;
        }

        return result;
    }
}
