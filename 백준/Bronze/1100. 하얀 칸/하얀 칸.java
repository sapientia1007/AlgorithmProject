import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 좌표 합이 짝수이면 하얀색
        int cnt = 0;
        String[][] arr = new String[8][8];
        for (int i=0; i<8; i++) {
            String[] inpt = br.readLine().split("");

            for (int j=0; j<8; j++) {
                arr[i][j] = inpt[j];

                if ((i+j)%2==0 && Objects.equals(arr[i][j], "F")) {
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
