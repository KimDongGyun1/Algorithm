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

        //split �Ŀ� ����� �Ǳ���

        // 1 2
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); //string->int ��ȯ�ϴ� �Լ� �Լ�
        int B = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(A+B)); //int->string ��ȯ�ϴ� �Լ�

        bw.flush(); //�Ⱦ��� ������ ���� �� 
        br.close(); //�Ⱦ��� ������ ���� ��
        bw.close(); //�Ⱦ��� ������ ���� ��


    }
}