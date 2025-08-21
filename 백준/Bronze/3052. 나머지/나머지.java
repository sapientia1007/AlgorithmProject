import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> arr = new HashSet<>();

        for (int i=0 ;i<10; i++) {
            int inpt = Integer.parseInt(br.readLine());
            arr.add(inpt % 42);
        }

        System.out.println(arr.size());
        br.close();
    }
}