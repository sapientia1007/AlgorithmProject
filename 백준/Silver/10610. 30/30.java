import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inpt = br.readLine();

        int[] count = new int[10];
        int sum = 0;
        boolean hasZero = false;

        for (char c : inpt.toCharArray()) {
            int digit = c - '0';
            count[digit]++;
            sum += digit;
            if (digit == 0) hasZero = true;
        }

        if (!hasZero || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (count[i]-- > 0) {
                sb.append(i);
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}