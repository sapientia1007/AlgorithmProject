import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] people = new int[N][2];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken()); 
            int tall = Integer.parseInt(st.nextToken());

            people[i][0] = weight; people[i][1] = tall;
        }

        for (int i=0; i<N; i++) {
            int rank = 0 ;
            int[] target = people[i];

            for (int j=0; j<N; j++) {
                if (j != i) {
                    if (people[j][0] > target[0] && people[j][1] > target[1]) {
                        rank+=1;
                    }
                }
            }
            System.out.print((rank+1)+ " ");
        }    
        br.close();
    }
}