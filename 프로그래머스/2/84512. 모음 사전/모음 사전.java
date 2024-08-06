import java.util.*; 

class Solution {
        static ArrayList<String> list; // 모음 문자열 저장한 사전 리스트
        String[] dict = new String[] {"A","E","I","O","U"}; // 모음 배열

        public int solution(String word) {
            int answer = 0;

            list = new ArrayList<>();
            dfs("", 0); // dfs 호출로 모든 가능한 문자열 생성

            for (int i=0; i<list.size(); i++) { // 주어진 단어가 리스트에서 몇번째 위치에 있는지 찾기
                if (word.equals(list.get(i))) answer = i;
            }
            return answer;
        }
        public void dfs(String str, int len) {
            list.add(str); // 현재 문자열 추가
            if (len == 5) return; // 문자열 길이가 5이면 종료 (최대문자열길이=5)
            for (int i=0; i<5; i++) { // 모든 모음을 현재 문자열에 추가하여 새로운 문자열 생성하는 재귀 호출
                dfs(str+dict[i], len+1);
            }
        }
    }