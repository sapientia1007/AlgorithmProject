import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static String[] arr;
    static String[] checkLst;
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N]; checkLst = new String[N];
        for (int i= 0; i<N; i++){
            arr[i] = br.readLine();
        }
        int numLen = arr[0].length();
        
        int idx = numLen - 1;
        while (true) {
            for (int i = 0; i < N; i++) {
                checkLst[i] = arr[i].substring(idx, numLen);
            }
            HashSet<String> hash = new HashSet<>(Arrays.asList(checkLst));
            if (hash.size() < N) {
                idx -= 1;
            }
            else {
                System.out.println(numLen - idx);
                System.exit(0);
            }
        }
    }
}
