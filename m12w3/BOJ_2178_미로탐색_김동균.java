package m12w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*4 6
101111
101010
101011
111011*/
public class BOJ_2178_미로탐색_김동균 {
	// 정적 클래스 따로 객체를 생성하지 않아도 변수나 함수를 사용할 수 있다
	static class Dot{
		int x,y,cnt;

		//alt shift s 
		public Dot(int x, int y, int cnt) {
			// this는 생성자 호출이 끝나고 초기화됨. 같은 이름을 붙여도 구분하여 사용가능
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	static int[] dx = {-1,1,0,0}; //행 - 상하
	static int[] dy = {0,0,-1,1}; //열 - 좌우
	static int N,M, answer;
	static int[][] map;
	static boolean[][] visited; // 방문 체크를 위한 visited 배열 true, false
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); // 한줄
		N = Integer.parseInt(st.nextToken()); // - 상하
		M = Integer.parseInt(st.nextToken()); // - 좌우
		
		//네모난 행렬표를 생각해보기
		map = new int[N][M];
		//방문배열  true면 방문했다 false면 아직 안했다.
		visited = new boolean[N][M];
		
		// 행 
		for (int i = 0; i < N; i++) {  
			// s : 101111 1행을 생각 - (0,0) (0,1) (0,2) ... (0,5) (0,0)부터 시작하는것을 기억하기
			String s = br.readLine(); //한줄
			// 열
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j)  - '0'; //string -> char  아스키코드값 변환한것
			}
		}
		
		// 지도에 값 다넣음
		
		//입력 끝
		
		//(0,0)부터 탐색 시작이고 1은 카운트 1부터 시작이기에 (0,0,0)이 아닌 (0,0,1)
		//(int x, int y, int cnt)
		bfs(new Dot(0,0,1));
		
		bw.write(String.valueOf(answer));
		
		bw.flush();
		br.close();
		bw.close();
		
		
	}
	
	// bfs: 하나의 점으로 시작하여 차례대로 모든 점을 한 번씩 방문하는 것
	private static void bfs(Dot dot) {
		// 연결 리스트 q는 선입선출
		Queue<Dot> q = new LinkedList<Dot>();
		//시작지점을 방문했다!!!
		visited[dot.x][dot.y]=true;
		//넣는다
		q.offer(dot);
		
		//큐가 비어있지 않으면 계속 반복 !는 논리 연산자. 부정을 뜻함
		while(!q.isEmpty()) {
			//빼준다
			Dot d = q.poll();
			
			// 4방향 검사
			for (int k = 0; k < 4; k++) {
				//next x (다음에 이동할 칸)
				int nx = d.x + dx[k];
				int ny = d.y + dy[k];
				
				// 1. 맵밖으로 나가면 안됨 예를들어 (0,-1)이렇게 될수 없음
				if(nx<0 || nx >= N || ny <0 || ny>= M) continue;
				// 2. 다음칸 map값이 0이면 안됨. 1이 길이니 1로만 가야한다.
				if(map[nx][ny]==0) continue;
				// 3. 전에 방문했던 곳인가. true면 방문o false면 방문x 
				if(visited[nx][ny]) continue;
				// 이동한 곳이 목적지일때 반환 (0,0)에서 시작이기때문에 N,M에서 -1씩 빼준다.
				if(nx == N-1 && ny == M-1) {
					answer = d.cnt+1;
					return;
				}
				visited[nx][ny]=true; // 방문 쳌
				q.offer(new Dot(nx, ny, d.cnt+1));
				
			}	
		}		
	}
}