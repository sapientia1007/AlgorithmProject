import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine()); // 총 금액
        int n = Integer.parseInt(br.readLine()); // 물건 종류 수

        int sum = 0;

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()) ;
            int a = Integer.parseInt(st.nextToken()); // 물건 가격
            int b = Integer.parseInt(st.nextToken()); // 물건 개수
            sum += a*b;
        }

        if (sum == x) System.out.println("Yes");
        else System.out.println("No");
        
        br.close();
    }
}