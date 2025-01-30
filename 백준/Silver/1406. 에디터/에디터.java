import java.io.*;
import java.util.*;

public class Main {
	static String inpt;  static int M; 
	static String todo; static Character mid;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		inpt = br.readLine(); int N=inpt.length();
		
		LinkedList<Character> list = new LinkedList<Character>();
		
		for (int i = 0; i < inpt.length(); i++) list.add(inpt.charAt(i));
		M = Integer.parseInt(br.readLine()); 
		
		ListIterator<Character> iter = list.listIterator();
		
		while (iter.hasNext()) {
			iter.next();
		}
		
		for (int i=0; i<M; i++) {
			todo = br.readLine();
			char c = todo.charAt(0);
			switch (c) {
			case 'L' :
				if (iter.hasPrevious()) iter.previous();
				break;
			case 'D' : 
				if (iter.hasNext()) iter.next();
				break;
			case 'B' :
				if (iter.hasPrevious()) 
					{
						iter.previous(); 
						iter.remove();
					}
				break;
			case 'P' :
				mid = todo.charAt(2);
				iter.add(mid);
				break;
			}
		}
		
		for (Character c : list) bw.write(c);
		br.close();bw.close();
	}
}
