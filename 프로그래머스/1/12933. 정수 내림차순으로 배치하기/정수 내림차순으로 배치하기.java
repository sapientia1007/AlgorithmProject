import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String nStr = String.valueOf(n);
        int nLen = nStr.length();
        Integer[] newArray = new Integer[nLen];
        
        int idx = 0 ;
        for (int i = 0 ; i < nLen ; i++) {
            Integer newNum = (Integer) (nStr.charAt(i)-'0');
            newArray[idx++] = newNum;
        }
        Arrays.sort(newArray, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i< newArray.length ; i ++ ){
            sb.append(newArray[i]);
        }
        
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}