package m1w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15649_N과M_1_김동균 {
    static int N,M;
    static boolean[] visited;
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 순서 있는
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 방문
        visited = new boolean[N+1];
        temp = new int[M]; // 내가뽑은애들 넣을거야
        permutation(0);

        br.close();
    }
    // 4 2
    // temp : [2,4] 2개
    // visited : f t f f 
    private static void permutation(int idx) {
//        2 ==2
        if(idx==M) {
            for (int i = 0; i < M; i++) {
                System.out.print(temp[i] + " "); // 1 4
            }
            System.out.println();
            return;
        }
        for (int  i = 1; i <= N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            temp[idx] = i;
            permutation(idx+1); 
            visited[i] = false;
        }
    }
}