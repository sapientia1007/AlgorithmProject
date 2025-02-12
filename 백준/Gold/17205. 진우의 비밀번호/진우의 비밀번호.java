import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String password = br.readLine();

        long cnt = 0;

        for (int i=0; i<password.length(); i++) {
            int k = password.charAt(i) - 'a'; // 현재 알파벳의 사전순 위치
            cnt += (k+1);
            for (int j=1; j<N-i; j++) {
                cnt += k * Math.pow(26, j); // 뒤에 나올 수 있는 경우
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
