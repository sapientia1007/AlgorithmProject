import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken(); String b = st.nextToken();

        int minCnt = Integer.MAX_VALUE;

        for (int i=0; i<= b.length()-a.length(); i++) {
            int cnt = 0;
            for (int j=0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(i+j)){
                    cnt ++;
                }
            }
            minCnt = Math.min(cnt,minCnt);
        }
        System.out.println(minCnt);
        br.close();
    }
}