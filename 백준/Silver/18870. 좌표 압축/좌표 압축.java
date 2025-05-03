import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] inpt = br.readLine().split(" ");
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(inpt[i]); 
        
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, cnt++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(map.get(num)).append(" ");
        }
        
        System.out.println(sb);
        br.close();
    }
}