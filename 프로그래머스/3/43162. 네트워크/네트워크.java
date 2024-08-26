import java.util.*;

class Solution {
        int[] parent ;
        public int find(int a){
            if (parent[a] == a) return a;
            return parent[a] = find(parent[a]);
        }

        public void union(int a, int b){
            a = find(a); b = find(b);
            if (a!=b) parent[b] = a;
        }

        public int solution(int n, int[][] computers) {
            int answer = 1;
            parent = new int[n];
            // 일단 부모 자기자신으로 담기
            for (int i=0; i<n; i++) parent[i] = i;

            for (int i = 0; i < computers.length; i++) {
                for (int j=0; j< computers[i].length; j++){
                    if (computers[i][j] == 1){
                        union(i, j);
                    }
                }
            }

            for (int i=0; i<n; i++){
                find(i);
            }
            
            HashSet<Integer> newtork = new HashSet<>();
            for (int p : parent){
                newtork.add(parent[p]);
            }
            answer = newtork.size();

            return answer;
        }
    }