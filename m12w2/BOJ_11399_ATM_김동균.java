package m12w2;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11399_ATM_김동균 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
//		사람의 수
        int N = Integer.parseInt(br.readLine());
//      인출하는데 걸리는 시간 배열
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
//      i가 들어오면 다시 i를 더해서 배열에 더해줌
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
//      제일 작은 친구가 맨 앞에 오도록 정렬 오름차순으로 정렬 시켜주는 메소드이다. ..처리시간이 빠른 사람 순서대로
        Arrays.sort(arr);
//      초기 최소값 설정 가장 ..빠른 손님의 처리시간으로 초기화
        int time = 0;

//      이전 친구 처리시간으로 생기는 대기시간과 자신의 처리시간을 더해 해당 친구가 소요하는 시간을 저장하고 더함
        for (int i = 0; i < N; i++){
            time += (arr[i] * (N - i));
        }
        bw.write(String.valueOf(time));

        bw.flush();
        br.close();
        bw.close();
	}

}
