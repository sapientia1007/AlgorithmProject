import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 1; i <= x; i++) {
            if (i < 100) {
                cnt++;
            } else {
                int hundreds = i / 100; // 백의 자리
                int tens = (i / 10) % 10; // 십의 자리
                int ones = i % 10; // 일의 자리

                if ((tens - hundreds) == (ones - tens)) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt); 
        br.close();
    }
}
