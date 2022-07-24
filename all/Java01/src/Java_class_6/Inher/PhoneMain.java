package Java_class_6.Inher;

import java.util.Scanner;


public class PhoneMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("폰을 선택하십시오 (1. 일반폰, 2.스마트폰): ");
		int user_input = sc.nextInt();
		switch (user_input) {
			case 1:
				Phone p = new Phone();
				System.out.println("메시지를 입력하십시오: ");
				String str = sc.next();
				p.sendTextMessage(str);
				break;
			case 2:
				SmartPhone sp = new SmartPhone();
				System.out.println("메시지를 입력하십시오: ");
				String str1 = sc.next();
				sp.sendTextMessage(str1);
				break;
		}
		
	}
}
