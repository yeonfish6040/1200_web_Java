package Java_class_002;

import java.util.Scanner;

public class UserInputTest {

	public static void main(String[] args) {
		print p = new print();
		p.p("User Input Test");
		p.p("*********************");
		
		// 프로그램 실행할 때 입력받는 경우
		// Argument, Value, Parameter
		p.p("Arguments1: " + args[0]);
		p.p("Arguments2: " + args[1]);
		p.p("# of Arguments: " + args.length);
		
		// 아무 때나 필요할 때 입력받는 경우
		Scanner sc = new Scanner(System.in);
		p.p("이름을 입력하십시오: ");
		String name = sc.next(); // next 는 문자열로 받는다
		p.p("나이를 입력하십시오: ");
		int age = sc.nextInt();
		String str = (age > 20)? "Java 점수를 입력하십시오" : "Jaca 점수를 입력해";
		p.p(str);
		float score_j = sc.nextFloat();
		String str2 = (age > 20)? "C 점수를 입력하십시오" : "C 점수를 입력해";
		p.p(str2);
		float score_c = sc.nextFloat();
		p.p("당신의 이름은 "+name+"입니다");
		p.p("당신의 나이는 "+age+"이시고,");
		p.p("평균점수는 "+(score_j+score_c)/2+"이시네요");
	}

}
