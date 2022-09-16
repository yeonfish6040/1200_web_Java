package Java_class_002;

import java.util.Random;

public class IfTest {

	public static void main(String[] args) {
		
		
		Random rd = new Random();
		
		print p = new print();
		p.t("If test");
		
		int a = 1;
		if(a > 0) {
			p.p("a is positive");
		}
		
		p.p("if-else");
		int b = -1;
		if (b > 0) {
			p.p("b is positive");
		}else {
			p.p("b is not positive");
		}
		
		p.p("if-else if ***");
		int c = 60;
		if (c > 50) {
			p.p("c is big number");
		} else if (c > 0){
			p.p("c is positive");
		} else {
			p.p("c is not positive");
		}
		
		p.p("if-else if-else");
		int d = 30;
		if(d > 0) {
			p.p("d is zero");
		}else if(d == 0) {
			p.p("d is zero");
		}else {
			p.p("d is negative");
		}
		
		// nested (중첩) if statement
		p.p("if-if ***");
		int math = 90;
		int eng = 35;
		if (math >= 60) 
			if(eng >= 60)
				p.p("Pass");
			else
				p.p("Fail");
		else
			p.p("fail");
		
		// 조건을 &&등의 연산자로 붂을 수 있음
		if(math > 60 && eng >= 60)
			p.p("Pass");
		else
			p.p("Fail");
		p.t("switch");
		
		int j = rd.nextInt(4);
		switch (j) {
			case 0:
				p.p("없니?");
				break;
			case 1:
				p.p("1인가?");
				break;
			case 2:
				p.p("2였네");
				break;
			case 3:
				p.p("3맞지");
				break;
			default:
				p.p("다 아닌데?");
		}
		switch (j) {
			case 0:
			case 1:
				p.p("꽝");
				break;
			case 2:
				p.p("당첨");
				break;
		}
	}

}
