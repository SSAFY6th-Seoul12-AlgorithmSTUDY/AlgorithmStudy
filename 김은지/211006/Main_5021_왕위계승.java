package baekjoon.topology_sort;

import java.io.*;
import java.util.*;

public class Main_5021_왕위계승 {
	
	static Map<String, Person> people;
	
	static class Person {
		double degree;
		List<String> child;
		
		public Person(double degree, List<String> child) {
			this.degree = degree;
			this.child = child;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); 
		
		people = new HashMap<>();
		people.put(br.readLine(), new Person(1.0, new ArrayList<>()));
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String child = st.nextToken();
			String parent1 = st.nextToken();
			String parent2 = st.nextToken();
			double d = 0.0;
			
			if (people.containsKey(parent1)) {
				d += people.get(parent1).degree/2;
			} else {
				people.put(parent1, new Person(0.0, new ArrayList<>()));
			}
			people.get(parent1).child.add(child);
			
			if (people.containsKey(parent2)) {
				d += people.get(parent2).degree/2;
			} else {
				people.put(parent2, new Person(0.0, new ArrayList<>()));
			}
			people.get(parent2).child.add(child);
			
			if (people.containsKey(child)) {
				people.get(child).degree = d;
				updateChildDegree(people.get(child));
			} else {
				people.put(child, new Person(d, new ArrayList<>()));
			}
		}
		
		double max = 0;
		String name = "";
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (people.containsKey(s) && people.get(s).degree > max) {
				max = people.get(s).degree;
				name = s;
			}
		}
		
		System.out.println(name);
	}
	
	static void updateChildDegree(Person p) {
		List<String> list = p.child;
		for (int j = 0; j < list.size(); j++) {
			people.get(list.get(j)).degree += p.degree/2;
			updateChildDegree(people.get(list.get(j)));
		}
	}

}
