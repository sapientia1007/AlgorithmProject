import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] currentArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int last = N-1;
        while (last > 0 && currentArr[last-1] <= currentArr[last]) last--;

        if (last == 0) System.out.println(-1);
        else {
            int idx = N-1;
            while (currentArr[idx] >= currentArr[last-1]) idx--;

            swap(currentArr, last-1, idx);
            reverse(currentArr, last, N-1); 
            print(currentArr);
        }

        br.close();
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        } 
    }

    private static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}

