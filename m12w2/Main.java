import java.util.Scanner;
//import java.util.Arrays;

public class Main {
public static void main(String[] args) {
    
	int[] N = null; //N:����� ��
	int sum=0;
	
	Scanner sc = new Scanner(System.in);
	int Num = sc.nextInt(); //Num: �Է¹��� ����� ��  
		N = new int[Num]; //new��� Ű���带 �̿��� �Է¹��� ������ �迭�� ���� �����Ҵ�
        
		for(int p=0; p<Num; p++) { // p: ����� �����ϴ� �ð�,������ �Է¹޾� �����迭 ����
			N[p]=sc.nextInt();
		}
			int i=0, j=0, temp=0;
		
			for ( ; i<N.length; i++) {
				for (j=i+1; j<N.length; j++) { //ġȯ
					if (N[i] > N[j])
                			temp = N[i];
                			N[i] = N[j];
                			N[j] = temp;
							}
				}
		for (int b = 0; b < N.length; b++) {
                sum += N[b];
        }
		System.out.println(+sum);
            
}
}
//�Էµ� ���ڵ� ���ϸ鼭 ���� ���� ������(��������) ����(ġȯ)->���� ���� �� ���� ���ʴ�� ���ϸ� ��