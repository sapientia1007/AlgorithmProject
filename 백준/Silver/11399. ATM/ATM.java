import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int res = 0;
        int allRes = 0;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0 ; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i=0; i<N; i++){
            allRes += res + arr[i];
            res += arr[i];
        }

        System.out.println(allRes);
    }
}