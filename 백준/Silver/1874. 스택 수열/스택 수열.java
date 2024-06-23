import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>(); 

        int n = Integer.parseInt(br.readLine());
        int start = 0;

        while (n-- >0) {
            int val = Integer.parseInt(br.readLine());
            if (val > start) {
                for (int i=start+1; i<=val; i++){
                    s.push(i);
                    sb.append("+").append("\n");
                }
                start = val;
            }
            else if (s.peek() != val) {
                System.out.println("NO");
                return;
            }
            s.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}