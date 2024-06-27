import java.io.*;
import java.util.*;

public class Main{
	static int n; static int r; static int c;
	static int cnt=0;
	static void check(int row, int col, int size) {
		if (row == r && col == c) {
			System.out.println(cnt);
			System.exit(0);
		}

		if ((r>=row)&& (c>=col) && (r<row+size) && (c<col+size)){
			check(row, col, size/2);
			check(row,col+size/2, size/2);
			check(row+size/2, col, size/2);
			check(row+size/2, col+size/2, size/2);
		} else {
			cnt += size*size;
		}

	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpt = br.readLine().split(" ");
		n = Integer.parseInt(inpt[0]); r = Integer.parseInt(inpt[1]); c = Integer.parseInt(inpt[2]);
		int len = (int) Math.pow(2, n); // 2^n 
		check(0, 0, len);
	}

}