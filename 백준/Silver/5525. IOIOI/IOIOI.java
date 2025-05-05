import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s =  br.readLine();

        int idx = 0; int count = 0; int answer = 0;
        while (idx < M-2) {
            if (s.charAt(idx) == 'I' && s.charAt(idx+1) == 'O' && s.charAt(idx+2) == 'I') {
                count++;
                if (count == N) {
                    answer++;
                    count--; 
                }
                idx += 2;
            } else {
                count = 0;
                idx++;
            }
        }
        System.out.println(answer);
        br.close();
    }
}