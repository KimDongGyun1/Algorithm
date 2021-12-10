import java.util.Scanner;
//import java.util.Arrays;

public class Main {
public static void main(String[] args) {
    
	int[] N = null; //N:사람의 수
	int sum=0;
	
	Scanner sc = new Scanner(System.in);
	int Num = sc.nextInt(); //Num: 입력받은 사람의 수  
		N = new int[Num]; //new라는 키워드를 이용해 입력받은 값으로 배열의 행을 동적할당
        
		for(int p=0; p<Num; p++) { // p: 사람이 인출하는 시간,정수를 입력받아 동적배열 생성
			N[p]=sc.nextInt();
		}
			int i=0, j=0, temp=0;
		
			for ( ; i<N.length; i++) {
				for (j=i+1; j<N.length; j++) { //치환
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
//입력된 숫자들 비교하면서 가장 작은 수부터(오름차순) 나열(치환)->가장 작은 수 부터 차례대로 더하면 됨