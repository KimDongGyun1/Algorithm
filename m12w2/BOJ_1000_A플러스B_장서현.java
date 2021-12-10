import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //split 후에 사용이 되긴함

        // 1 2
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); //string->int 변환하는 함수 함수
        int B = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(A+B)); //int->string 변환하는 함수

        bw.flush(); //안쓰면 컴파일 오류 남 
        br.close(); //안쓰면 컴파일 오류 남
        bw.close(); //안쓰면 컴파일 오류 남


    }
}