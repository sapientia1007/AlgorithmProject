import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] arr = new boolean[21];
        int M = Integer.parseInt(br.readLine()); // 수행 연산 수
        
        for (int i=0; i<M; i++) {
            String[] inpt = br.readLine().split(" ");
            String command = inpt[0];

            if (command.equals("all")) {
                for (int j=0; j<21; j++) arr[j] = true;
            } else if (command.equals("empty")) {
                for (int j=0; j<21; j++) arr[j] = false;
            } else {
                int number = Integer.parseInt(inpt[1]);
                switch (command) {
                    case "add" :
                        arr[number] = true;
                        break;
                    case "remove" : 
                        arr[number] = false;
                        break;
                    case "check" :
                        sb.append(arr[number] ? 1 : 0).append('\n');
                        break;
                    case "toggle" :
                        if (arr[number]) arr[number] = false;
                        else arr[number] = true;
                        break;             
                }
            }
        }
        System.out.print(sb);
    }
}