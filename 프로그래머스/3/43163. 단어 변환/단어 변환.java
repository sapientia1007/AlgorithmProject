class Solution {
        static boolean[] v;
        static int answer = 0;
        public int solution(String begin, String target, String[] words) {
            v = new boolean[words.length];

            dfs(begin, target, words, 0);
            return answer;
        }

        static void dfs(String now, String target, String[] words, int cnt) {
            if (now.equals(target)) { // 원하는 단어와 같아지면
                answer = cnt;
                return;
            }

            for (int i=0; i<words.length; i++) {
                if (v[i] == true) continue; // 이미 방문한 단어면 pass

                String word = words[i]; int notEqual = 0;
                for (int j=0; j<now.length(); j++) {
                    if (now.charAt(j) != words[i].charAt(j)) notEqual++; // 단어 별 다른 알파벳 개수
                }
                // 1개만 다르면 탐색
                if (notEqual == 1){
                    v[i] = true;
                    dfs(word, target, words, cnt+1);
                    v[i] = false; // 방문 초기화
                }
            }
        }
    }