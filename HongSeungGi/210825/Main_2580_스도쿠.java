import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2580_스도쿠 {
	static boolean flag;
	public static boolean check(int[][] b, int r, int c, int num) {
		for(int i = 0; i < 9; i++) {
			if(b[r][i] == num) return false;
		}
		for(int i = 0; i < 9; i++) {
			if(b[i][c] == num) return false;
		}
		int smallr = r/3 * 3;
		int smallc = c/3 * 3;
		for(int i = smallr; i < smallr+3; i++) {
			for(int j = smallc; j < smallc+3; j++) {
				if(b[i][j] == num) return false;
			}
		}
		return true;
	}
	public static void push(int[][] b, int r, int c) {
		if(flag) return;
		if(c == 9) {
			push(b, r+1, 0);
			return;
		}
		if(r == 9) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(b[i][j]+" ");
				}
				System.out.println();
			}
			flag = true;
			return;
		}
		if(b[r][c] == 0) {
			for(int i = 1; i <= 9; i++) {
				if(check(b,r,c,i)) {
					b[r][c] = i;
					//System.out.println(r+" "+c+" "+b[r][c]);
					push(b,r,c+1);
					b[r][c] = 0;
				}
			}

		}
		else push(b,r,c+1);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] board = new int[9][9];
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		push(board,0,0);
		/*for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}*/
	}

}
