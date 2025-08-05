import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inpt = br.readLine();
        
        int[] nums = inpt
                    .chars()
                    .map(c -> c - '0')
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();

        int sum = 0;
        boolean hasZero = false; 
        for (int num : nums) {
            if (num == 0) hasZero = true;
            sum += num;
        }

        if (!hasZero || sum%3 != 0) {
            System.out.println(-1);
        } else {
            for (int num : nums) {
                System.out.print(num);
            }
            System.out.println();
        }

        br.close();
    }
}