package m1w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기_김동균 {
	static class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, cnt;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> list; // 전역번수로서 list만 있으면 다른 곳에서 쓸수있음.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		// ArrayList<Integer> list = new ArrayList<Integer>(); 원래 이렇게 입력하는것
		// 전역변수로 위에 지정해줬기에 list = 가능
		list = new ArrayList<Integer>();

		map = new int[N][N]; // 정사각형이기에 가로세로를 N
		visited = new boolean[N][N]; // 방문배열
		cnt = 0; // 단지개수를 세기위해

		// 배추와는 다르게 문자가 붙어있다. 지도에 값을 넣는 방법
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0'; // string 에서 char로 변환 아스키코드값 변환
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 || visited[i][j]) // 값이 0이거나 방문했을때 넘김.
					continue;
				bfs(new Dot(i, j)); // 값이 0이아니거나 방문하지않았을때.
				cnt++; // 카운트 숫자를 올린다.
			}
		}

		bw.write(String.valueOf(cnt) + "\n"); // 단지수가 몇개 있는지!
		Collections.sort(list);// 오름차순으로 정렬

//		for (int i = 0; i < list.size(); i++) {
//			bw.write(String.valueOf(list.get(i)) + "\n");
//		}
		// index가 없다. 그냥 for문을 써도 되지만 코드가 좀 더 간결함
		// list 안에 있는 숫자를 불러옴
		for (int value : list) {
			bw.write(String.valueOf(value) + "\n");
		}

		bw.flush();
		br.close();
		bw.close();

	}

	private static void bfs(Dot dot) {
		// q 생성
		Queue<Dot> q = new LinkedList<Dot>();
		// 시작지점 방문
		visited[dot.x][dot.y] = true;
		// q안에 넣는다
		q.offer(dot);
		int gagu = 0;

		while (!q.isEmpty()) {
			// 빼줌
			Dot d = q.poll();
			// 빼고 가구수올리기
			gagu++;

			for (int k = 0; k < 4; k++) {
				// 4방향으로 검사하기
				int nx = d.x + dx[k];
				int ny = d.y + dy[k];

				// 맵밖 x
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				// 다음칸이 0이면 x
				if (map[nx][ny] == 0)
					continue;
				// 방문한곳이면 x
				if (visited[nx][ny])
					continue;

				visited[nx][ny] = true; // 방문쳌ㅋㅋ
				q.offer(new Dot(nx, ny)); // 새로운 큐넣기
			}
		}
		list.add(gagu); // while문이 끝나면 gagu값을 list에 추가!
	}

}
