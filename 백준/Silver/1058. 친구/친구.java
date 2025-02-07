import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] friends = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                friends[i][j] = (line.charAt(j) == 'Y');
            }
        }

        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            boolean[] isTwoFriend = new boolean[N];

            for (int j = 0; j < N; j++) {
                if (i==j) continue;

                if (friends[i][j]) isTwoFriend[j] = true;
                else {
                    for(int k=0; k<N; k++){
                        if (friends[i][k] && friends[k][j]) {
                            isTwoFriend[j] = true;
                            break;
                        }
                    }
                }
            }
            int cnt = 0;
            for (boolean tOrf : isTwoFriend) {if (tOrf) cnt++;}
            maxNumber = Math.max(maxNumber, cnt);
        }
        System.out.println(maxNumber);
        br.close();
    }
}
