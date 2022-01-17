package m1w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 중복조합 1 1도 취급한다는말
// 조합에는 1 2랑 2 1을 같은 취급을 한다는 것이 visited가 의미가 없어지기에 선언x
public class BOJ_15652_N과M4_김동균 {
	static int N, M;
	static int[] temp;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		temp = new int[M];
		sb = new StringBuilder();
		
		combination(0,1); // 0 1 로밑에 들어간다
		
		bw.write(String.valueOf(sb));
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	// 1 1 / 1 2 / 1 3 / 1 4 / 2 2 / 2 3 / 2 4 / 3 3 / 3 4 / 4 4

								    // 레벨       현재상태
	private static void combination(int idx, int cur) {
		
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(temp[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// cur는 1로부터 시작
		for (int i = cur; i <= N; i++) {
			temp[idx] = i;
			combination(idx + 1, i);// 조합에서 i+1해줬는데 +1만 빼주면 중복조합 완성
		}
	}

}
