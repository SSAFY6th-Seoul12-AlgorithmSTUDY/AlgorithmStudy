package baejoon.MST;

import java.io.*;
import java.util.*;

public class Main_4386_별자리만들기 {
	
	static class Star implements Comparable<Star> {
		int n;
		double d;

		public Star(int n, double d) {
			this.n = n;
			this.d = d;
		}

		@Override
		public int compareTo(Star o) {
			return Double.compare(this.d, o.d);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double[][] point = new double[n][2];
		PriorityQueue<Star>[] stars = new PriorityQueue[n];
		boolean[] selected = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			point[i][0] = Double.parseDouble(st.nextToken());
			point[i][1] = Double.parseDouble(st.nextToken());
			stars[i] = new PriorityQueue<>();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				double d = Math.pow(Math.pow(Math.abs(point[i][0]-point[j][0]), 2) + Math.pow(Math.abs(point[i][1]-point[j][1]), 2), 0.5);
				stars[i].add(new Star(j, d));
				stars[j].add(new Star(i, d));
			}
		}
		
		selected[0] = true;
		double answer = 0;
		int cnt = 0;
		List<Integer> selectedStar = new ArrayList<Integer>();
		selectedStar.add(0);
		while(cnt < n-1) {
			double min = Double.MAX_VALUE;
			int minIdx = -1;
			for (int i = 0; i < selectedStar.size(); i++) {
				if (stars[selectedStar.get(i)].isEmpty()) continue;
				Star star = stars[selectedStar.get(i)].peek();
				while (!stars[selectedStar.get(i)].isEmpty() && selected[star.n]) {
					stars[selectedStar.get(i)].poll();
					star = stars[selectedStar.get(i)].peek();
				}
				if (min > star.d) {
					min = star.d;
					minIdx = selectedStar.get(i);
				}
			}
			
			Star star = stars[minIdx].poll();
			selected[star.n] = true;
			selectedStar.add(star.n);
			answer += star.d;
			cnt++;
		}
		
		System.out.printf("%.2f", answer);
	}

}
