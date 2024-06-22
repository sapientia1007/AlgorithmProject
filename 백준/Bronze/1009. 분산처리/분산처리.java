import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int t;
    static int r;
    public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            t = Integer.parseInt(br.readLine());

            for (int i=0; i<t; i++){
                r= 1;
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                for (int j=0; j<b; j++){
                    r = (r*a)%10;
                }
                if (r==0) {System.out.println(10);}
                else {System.out.println(r);}
            }

    }

}