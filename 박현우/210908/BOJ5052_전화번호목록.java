package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5052_전화번호목록 {
	// 트라이 알고리즘은 문자열을 트리 구조로 저장해 빠르게 찾는 알고리즘 기법 중의 하나이다.
	// 트라이 알고리즘은 3개 혹은 4개의 메소드가 필요하다.
	// 1. 생성자, 클래스 - 각 Node의 정보를 정의한 클래스. 자신의 문자, 연결되는 문자들의 정보, 문자열이 완성되는가 여부를 저장
	// 1-1. 뒤로 연결되는 문자열, 즉 자신의 뒤로 올 수 있는 모든 문자열을 저장하는 배열이 필요하다.
	// 1-2. 현재 노드가 문자 완성이 되는지 여부 파악하는 변수가 필요하다.
	// 1-3. 현재 노드에 연결된 문자열의 개수를 담은 변수가 필요하다.
	// 1-4. 현재 노드의 값이 저장된 변수가 필요하다.

	// 2. 문자열 삽입하기 - 현재 문자열을 하나씩 떼어 루트부터 시작해 자식 노드에 현재 문자열이 있는지 판단한다.
	// 또한, 현재 문자열 인덱스에 해당하는 자식노드에 아무것도 없다면(null), 새로운 객체를 만들어 저장한다.

	// 3. 문자열 찾기 - 삽입과 비슷하게 루트부터 시작해 자식노드에 현재 문자열 인덱싱을 한뒤, 데이터가 있으면 계속내려간다.
	// 현재 depth가 문자열의 길이라면 멈추고 true 반환, 중간에 없는 자식노드가 발견되면 false 반환

	// 4. 문자열 삭제하기 - 하기싫엉ㅠ

	static final int LEN = 10; // 0~9까지라 10으로 설정

	// 1. 클래스
	static class Trie {
		boolean isTerminal; // 해당 노드가 마지막인지 여부 판단
		Trie[] child; // 자식노드

		Trie() { // 생성자.
			isTerminal = false;
			child = new Trie[LEN];
			for (int i = 0; i < LEN; i++) {
				child[i] = null; // 처음 자식노드들은 아무것도 없으니 null로 초기화
			}
		}
	}

	static Trie root; // 루트는 단일 객체

	// 2. 문자열 삽입
	static void insert(String key) {
		Trie now = root; // 현재 객체에 루트를 삽입하여 루트부터 찾기.

		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i); // 현재 문자열을 하나씩 뗀다.
			int index = c - '0'; // 인덱싱
			if (now.child[index] == null) { // 만약 현재 문자로 이어지는 문자열이 존재하지 않는다면
				now.child[index] = new Trie();
			}
			now = now.child[index];
		}
		now.isTerminal = true; // for문을 다 돌았으니 여기서 끝난다고 알림.
	}

	// 3. 문자열 찾기
	static boolean avail(String key) {
		Trie now = root; // 똑같음

		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - '0';
			if (now.isTerminal) // 현재 문자열까지 모두 포함하면서 완전한 문자열이 존재하는 거니까 false 리턴해라
				return false;
			now = now.child[index]; // 아니면 탐색 계속 진행
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int t = Integer.parseInt(br.readLine());
			String[] temp = new String[t];
			root = new Trie(); // 루트 새로 만들어
			for (int i = 0; i < t; i++) {
				temp[i] = br.readLine();
				insert(temp[i]);
			}
			boolean pos = true;
			for (int i = 0; i < t; i++) {
				if (!avail(temp[i])) { // 하나라도 false면 끝
					pos = false;
					break;
				}
			}
			System.out.println(pos ? "YES" : "NO");
		}
	}
}
