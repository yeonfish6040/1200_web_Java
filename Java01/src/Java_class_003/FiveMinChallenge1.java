package Java_class_003;

import java.util.Scanner;

public class FiveMinChallenge1 {

	public static void main(String[] args) {
		// Pseudo Code (수도 코드)
		// 0. 프로그램을 시작한다.
		System.out.println("백신접종요일 계산기");
		Scanner sc = new Scanner(System.in);
		// 1. 이름입력 받아서 nam 변수에 저장
		System.out.print("이름을 입력하세요: ");
		String nam = sc.next();
		// 2. 주민번호 맨 뒷자리 입력을 받아 final_nam 변수에 저장
		System.out.print("주민번호 뒷자리를 입력하세요: ");
		int final_nam = sc.nextInt();
		// 3. 입력되 갑을 출력한다
		System.out.println("=========");
		System.out.print(nam+", "+final_nam+"\n");
		System.out.println("=========");
		// 4. 뒷자리가 1,6 이면 월, 2,7이면 화, 3,8이면 수, 4,9면 목, 5,0이면 금
		String day = "";
		switch (final_nam) {
			case 1:
			case 6:
				day = "월";
				break;
			case 2:
			case 7:
				day = "화";
				break;
			case 3:
			case 8:
				day = "수";
				break;
			case 4:
			case 9:
				day = "목";
				break;
			case 5:
			case 0:
				day = "금";
				break;
				
		}
		// 5. ***님의 접종일은 *요일입니다. 요일 지켜서 오세요 를 출력한다
		System.out.println(nam+"님의 접종일은 "+day+"요일입니다. 요일 지켜서 오세요.");
	}

}
