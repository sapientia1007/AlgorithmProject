import java.io.*;
import java.util.*;

public class Main {
    static String N; static String M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = st.nextToken() ; M = st.nextToken();
        StringBuilder newN = new StringBuilder(); StringBuilder newM = new StringBuilder();

        for (int i=N.length()-1; i>=0; i--) {
            newN.append(N.charAt(i));
        }

        for (int i=M.length()-1; i>=0; i--) {
            newM.append(M.charAt(i));
        }

        int answer = Integer.parseInt(String.valueOf(newN)) + Integer.parseInt(String.valueOf(newM));
        int reverse = 0;
        while (answer != 0) {
            int digit = answer % 10;
            reverse = reverse*10+digit;
            answer/=10;
        }
        System.out.println(reverse);
        br.close();
    }
}
