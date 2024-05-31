
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        // a를 b번 곱해서 c로 나눔
        System.out.println(pow(a, b, c));
    }

    public static long pow(int a, int b, int c) {
        if (b == 0) {
            return 1;
        }
        long temp = pow(a, b / 2, c);
        temp = (temp * temp) % c;
        if (b % 2 != 0) {
            temp = (temp * a) % c;
        }
        return temp;
    }
}
