import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 해당 배열 저장
        HashMap<String, Integer> numbers = new HashMap<>();
        for (int i=0; i<phone_book.length; i++){
            numbers.put(phone_book[i], i);
        }
        // 특정 번호의 접두가 해시에 key 중 존재한다면 answer=false
        for (int i=0; i<phone_book.length; i++){
            for (int j=0; j<phone_book[i].length(); j++){
                if (numbers.containsKey(phone_book[i].substring(0, j))) answer = false;
            }
        }
        return answer;
    }
}