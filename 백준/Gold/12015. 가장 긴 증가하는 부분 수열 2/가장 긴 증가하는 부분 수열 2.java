import java.util.*;
import java.io.*;

public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            List<Integer> list = new ArrayList<>();
            list.add(0);

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i=0; i<N; i++){
                int value = Integer.parseInt(st.nextToken());
                arr[i] = value;

                if (value > list.get(list.size()-1)) {
                    list.add(value);
                }
                else{
                    int left = 0;
                    int right = list.size() - 1;

                    while(left < right){
                        int mid = (left + right)/2;
                        if(list.get(mid) >= value){
                            right = mid;
                        }else{
                            left = mid + 1;
                        }
                    }
                    list.set(right, value); // right index에 위치한 값을 value로 변경
                }
            }
            System.out.println(list.size() - 1);
            br.close();
        }
    }