import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[]  a ;
    static int[] b ;
    static StringBuilder sb;
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); sb = new StringBuilder();
        a = new int[N]; b = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = a[i];
        }

        Arrays.sort(b);

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++) {
                if (a[i]==b[j]) {
                    sb.append(j + " ");
                    b[j] = -1;
                    break;
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}