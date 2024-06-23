import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    static int n; static int m;
    static int MIN = Integer.MAX_VALUE;
    static int[][] arr; static boolean[] check;
    static ArrayList<Point> HouseList = new ArrayList<>();
    static ArrayList<Point> ChickenList = new ArrayList<>();

    static void back(int cnt, int start){
        if (cnt == m) {
            int sum = 0;
            for (int i=0; i<HouseList.size(); i++){
                int count = Integer.MAX_VALUE;
                for (int j=0; j<ChickenList.size(); j++){
                    if (check[j] == true){
                        int val = Math.abs(HouseList.get(i).x - ChickenList.get(j).x)
                                + Math.abs(HouseList.get(i).y - ChickenList.get(j).y);
                        count = Math.min(count, val);
                    }
                }
                sum += count;
            }
            MIN = Math.min(MIN, sum);
            return;
        }
        for (int i=start; i<ChickenList.size(); i++){
            check[i] = true;
            back(cnt+1, i+1);
            check[i] =false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    HouseList.add(new Point(i,j));
                } else if (arr[i][j]==2) {
                    ChickenList.add(new Point(i,j));
                }
            }
        }

        check = new boolean[ChickenList.size()];
        back(0,0);
        System.out.println(MIN);
        br.close();
        }
    }
