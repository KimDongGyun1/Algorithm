package m12w2;

import java.util.Scanner;

public class BOJ_1000_A플러스B {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // Scanner 클래스를 사용하기 위해 객체 생성
		int a = sc.nextInt(); // 입력받은 정수를 a에 저장한다
		int b = sc.nextInt(); // 입력받은 정수를 b에 저장한다
		sc.close(); // 생성한 Scanner 객체는 불필요한 리소스 낭비를 위해 종료를 하면 메모리 사용량이 줄어든다
			
		System.out.println(a + b); // a,b에 저장한 변수를 더해준다
		
	}

}