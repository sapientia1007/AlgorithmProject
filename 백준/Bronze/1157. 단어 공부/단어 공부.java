import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine().toUpperCase();
        ArrayList ans = new ArrayList();
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i=0; i<words.length(); i++){
            char word = words.charAt(i);
            if (dict.containsKey(word)){
                dict.put(word, dict.get(word)+1);
            } else {
                dict.put(word, 1);
            }
        }

        int maxNum = Collections.max(dict.values());
        for (char alphabet : dict.keySet()){
            if (dict.get(alphabet) == maxNum) ans.add(alphabet);
        }
        if (ans.size()>1) sb.append("?");
        else {
            for (Object a : ans) {
                sb.append(a.toString());
            }
        }
        System.out.println(sb);
        br.close();
    }
}