package Java_class_3;

import java.util.Scanner;

public class LoopTest {

	public static void main(String[] args) {
		// 1. while loop
		int i = 0;
		
		while(i < 10) {
			if (i == 7) {
				System.out.println("Lucky");
			} else if (i == 9) {
				System.out.println("End");
			} else {
				System.out.println(";;");
			}
			i++;			
		}
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("행동을 선택하세요(1.공격, 2.도망): ");
			i = sc.nextInt();
			if(i == 1 || i == 2) {
				break;
			}
			System.out.println("잘못입력하셨습니다.");
		}
		if (i == 1) System.out.println("몬스터가 화가나서 100000000 데미지를 주었습니다");
		if (i == 2) System.out.println("당신이 등을 보이자 몬스터가 야생본능에 의해 당신을 사냥하였습니다");
		
		// 2. for loop
		for(int j = 0;j<100;j++) {
			for(int k=0;k<=j;k++) {
				System.out.print("*");
			}
			System.out.println();
			j += 1; // for 변수에 사용자의 개입으로 적용이됨
		}
//		int t = 0;
//		for(;;) {
//			System.out.println(t);
//			t++;
//		}
		// 3. do, while
		int y = 0;
		do {
			System.out.println("hi");
			y++;
		} while (y <= 10);
		
		// 4. break, continue
		// 1에서부터 10까지의 숫자 중 3의 배수만 출력하지 않는다
		for(int l=1;true;l++) {
			if(l==11) break;
			else {
				if (l%3 == 0) {
					continue;
				}
				System.out.println(l);
			}
		}
	}

}
