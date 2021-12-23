package m12w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추_김동균 {
	static class Dot {
		int x, y;

		// alt shift s
		public Dot(int x, int y) {
			// this는 생성자 호출이 끝나고 초기화됨. 같은 이름을 붙여도 구분하여 사용가능
			this.x = x;
			this.y = y;
		}

	}

	static int[] dx = { -1, 1, 0, 0 }; // 행 - 상하
	static int[] dy = { 0, 0, -1, 1 }; // 열 - 좌우
	static int N, M, K, cnt; // K는 배추가 심어져 있는 위치의 개수
	static int[][] map;
	static boolean[][] visited; // 방문 체크를 위한 visited 배열 true, false

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); // 한줄

			N = Integer.parseInt(st.nextToken()); // 가로
			M = Integer.parseInt(st.nextToken()); // 세로
			K = Integer.parseInt(st.nextToken()); // 배추 개수
			// 네모난 행렬표를 생각해보기
			map = new int[N][M];
			// 방문배열 true면 방문했다 false면 아직 안했다.
			visited = new boolean[N][M];
			cnt = 0;

			// 배추의 개수만큼 1을 집어넣는 것 0 0을 입력하면 map[0][0]자리에 1이 들어간다!
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[x][y] = 1;
			}
			

			// map이 1이고 방문하지 않았다면 새로운 Dot에 넣어주고 cnt를 하나 추가한다.
			for (int i = 0; i < N; i++) {
				//System.out.println(Arrays.toString(map[i])); // 배열 확인하기
				for (int j = 0; j < M; j++) {
					// visited[i][j]해버리면 배추지렁이개수를 더세어버리게된다.
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(new Dot(i,j));
						cnt++;
					}
				}
			
			}
			
			bw.write(String.valueOf(cnt)+"\n");

		}
		bw.flush();
		br.close();
		bw.close();

	}

	// bfs: 하나의 점으로 시작하여 차례대로 모든 점을 한 번씩 방문하는 것
	private static void bfs(Dot dot) {
		// 연결 리스트 q는 선입선출
		Queue<Dot> q = new LinkedList<Dot>();
		// 시작지점을 방문했다!!!
		visited[dot.x][dot.y] = true;
		// 넣는다
		q.offer(dot);

		// 큐가 비어있지 않으면 계속 반복 !는 논리 연산자. 부정을 뜻함
		while (!q.isEmpty()) {
			// 빼준다
			Dot d = q.poll();

			// 4방향 검사
			for (int k = 0; k < 4; k++) {
				// next x (다음에 이동할 칸)
				int nx = d.x + dx[k];
				int ny = d.y + dy[k];

				// 1. 맵밖으로 나가면 안됨 예를들어 (0,-1)이렇게 될수 없음
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				// 2. 다음칸 map값이 0이면 안됨. 1이 길이니 1로만 가야한다.
				if (map[nx][ny] == 0)
					continue;
				// 3. 전에 방문했던 곳인가. true면 방문o false면 방문x
				if (visited[nx][ny])
					continue;
//				if (map[nx][ny] == 1 && !visited[nx][ny]) {
//					visited[nx][ny] = true;
//					answer = cnt + 1;
//					return;
//					// 이동한 곳이 목적지일때 반환 (0,0)에서 시작이기때문에 N,M에서 -1씩 빼준다.
////					if (nx == N - 1 && ny == M - 1) {
////						answer = d.cnt + 1;
////						return;
//				}
				visited[nx][ny] = true; // 방문 쳌
				q.offer(new Dot(nx, ny));

			}
		}
	}
}
