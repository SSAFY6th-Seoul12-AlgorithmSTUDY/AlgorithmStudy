package programmers.kakao;

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2019_길찾기게임 {
	
	static int[][] answer;
	static int answerIdx;
	static boolean[] visited;
	
	static class Point {
		int x, y, idx, left, right, parent;
		boolean parentLeft;

		public Point(int x, int y, int idx, int left, int right, int parent) {
			this.x = x;
			this.y = y;
			this.idx = idx;
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.parentLeft = false;
		}

	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(solution(new int[][] {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}})));
		//[[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]
	}

	public static int[][] solution(int[][] nodeinfo) {
		int N = nodeinfo.length;
        answer = new int[2][N];
        Point[] point = new Point[N];
        
        for (int i = 0; i < N; i++) {
			point[i] = new Point(nodeinfo[i][0], nodeinfo[i][1], i+1, -1, -1, 0);
		}
        
        Arrays.sort(point, (o1, o2)->Integer.compare(o1.y, o2.y)==0?Integer.compare(o1.x, o2.x):-Integer.compare(o1.y, o2.y));
        int y = point[0].y;
        int parentIdx = 0;
        int nextParentIdx = 0;
        int currIdx = 1;
        while (currIdx < N) {
        	if (y > point[currIdx].y) {
        		parentIdx = nextParentIdx;
        		nextParentIdx = currIdx;
        		y = point[currIdx].y;
        	}
			if (point[currIdx].x < point[parentIdx].x) {
				point[currIdx].parent = parentIdx;
				point[currIdx].parentLeft = true;
				point[parentIdx].left = currIdx++;
			} else {
				if (point[parentIdx].y != point[parentIdx+1].y) {
					point[currIdx].parent = parentIdx;
					point[parentIdx].right = currIdx++;
					continue;
				}
				Point p = point[parentIdx];
				while (!p.parentLeft) {
					p = point[p.parent];
				}
				if (point[currIdx].x < point[p.parent].x) {
					point[currIdx].parent = parentIdx;
					point[parentIdx].right = currIdx++;
				} 
				parentIdx++;
			}
		}
        
        answerIdx = 0;
        visited = new boolean[N];
        preorder(point, 0);
        answerIdx = 0;
        visited = new boolean[N];
        postorder(point, 0);
        
        return answer;
        
    }
	
	static void preorder(Point[] p, int pIdx) {
		if (pIdx == -1 || visited[pIdx]) return;
		
		answer[0][answerIdx++] = p[pIdx].idx;
		visited[pIdx] = true;
		preorder(p, p[pIdx].left);
		preorder(p, p[pIdx].right);
	}
	
	static void postorder(Point[] p, int pIdx) {
		if (pIdx == -1 || visited[pIdx]) return;
		
		postorder(p, p[pIdx].left);
		postorder(p, p[pIdx].right);
		answer[1][answerIdx++] = p[pIdx].idx;
		visited[pIdx] = true;
	}
	

}
