import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/10845
public class Main {

    static int t; static Deque<Integer> q= new LinkedList<Integer>();
    static int b;
    public static void main(String[] args) throws Exception{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            t = Integer.parseInt(br.readLine());

            for (int i=0; i<t; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                try {
                    b = Integer.parseInt(st.nextToken());
                } catch (NoSuchElementException e){
                    b = 0;
                }
                switch (a) {
                    case "push" :
                        q.addFirst(b);
                        break;
                    case "pop" :
                        if (q.isEmpty()) {
                            System.out.println(-1);
                        } else {
                            System.out.println(q.pollLast());
                        }
                        break;
                    case "size" :
                        System.out.println(q.size());
                        break;
                    case "empty" :
                        System.out.println(q.isEmpty()==true? 1: 0);
                        break;
                    case "front" :
                        System.out.println(q.isEmpty()==true? -1 :q.peekLast());
                        break;
                    case "back" :
                        System.out.println(q.isEmpty()==true?-1:q.peekFirst());
                        break;
                }
            }
        }
    }