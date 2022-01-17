package m1w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


// 중복순열
public class BOJ_15651_N과M3_김동균 {
	static int N, M;
	static boolean[] visited;
	static int[] temp;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		temp = new int[M];
		sb = new StringBuilder();
		
		permutaion(0);
		bw.write(String.valueOf(sb));
		
		bw.flush();
		br.close();
		bw.close();
	}

	private static void permutaion(int idx) {
		
		// syso로 하니 시간초과가 떠서.. 찾아보니 sb를 이용하면 문자열을 담을때 메모리를 줄일수있다
		if(idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(temp[i]).append(" "); 
			}
			sb.append("\n");
			return;
		}
		// visited 배열처리가 없으면 중복순열이 된다.
		for (int i = 1; i <= N; i++) {
			temp[idx] = i;
			permutaion(idx+1);
			
		}
	}

}
