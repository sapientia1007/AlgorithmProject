import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException{
		//입력값 처리하는 BufferedReader
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//결과값 출력하는 BufferedWriter
        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] count = new int[N+1];	//각 학생의 앞 학생 수 저장 배열
		ArrayList<ArrayList<Integer>> rel = new ArrayList<>();	//각 학생 비교 정보 저장
        	for(int i=0;i<=N;i++)
			rel.add(new ArrayList<>());
		
        	//비교 정보 저장 및 앞 학생 개수 세기
        	for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			rel.get(A).add(B);	//비교 정보 저장
			count[B]++;	//개수 증가
		}
		StringBuilder answer = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		//앞 학생이 필요없는 학생들 모두 Queue 저장
        	for(int i=1;i<=N;i++) {
			if(count[i] == 0)	//앞 학생이 없는 경우
				q.add(i);
		}
       		//위상 정렬 탐색 진행!
		while(!q.isEmpty()) {
			int cur = q.poll();
			answer.append(cur).append(" ");
		//비교한 학생을 탐색!
            	for(int next : rel.get(cur)) {
				count[next]--;	//앞 학생이 줄에 포함되었으므로 - 1
				if(count[next] == 0)	//앞 학생 모두 줄에 포함되어서 줄 서기 가능!
					q.add(next);
			}
		}
		bw.write(answer.toString());	//줄을 선 결과 BufferedWriter 저장
		bw.flush();		//결과 출력
		bw.close();
		br.close();

	}
}