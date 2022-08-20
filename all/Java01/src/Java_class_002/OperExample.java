package Java_class_002;

public class OperExample {

	public static void main(String[] args) {
		print p = new print();
		// 1. 대입
		int num = 10;
		p.p(num);
		
		// 2. 더하기
		num += 1;
		p.p(num);
		
		// 3. 빼기
		num -= 2;
		p.p(num);
		
		// 4. 곱하기
		num *= 2;
		p.p(num);
		
		p.p(num % 7);
		
		// 5. 나누기
		float num_f = (float)10.0 / 4;
		p.p(num_f);
		
		// 6. 0 으로 나누기
//		num = 10 / 0; / by zero
//		p.p(num);
		
		// 7. 증감 연산
		int a = 10;
		int b = 10;
		a++;
		++b;
		p.p(a);
		p.p(b);
		
		int x = a++;
		int y = ++b;
		p.p(x);
		p.p(y);
		
		// 8. 비교연산
		a = 10; b = 5;
//		p.p("a">b); error string
		p.p(a>b);
		p.p(a<b);
		p.p(a==b);
		p.p(a!=b);
		p.p('a'>'b');
		
		// 9. 논리 연산
		p.p(true && false);
		p.p(true || false);
		
		// 삼항연산자
		int score = 80;
		String dad1 = (score>60)? "잘했다." : "대ㅗㄷ";
		String dad2 = (score>99)? "당연" : "이것도 점수냐";
		p.p(dad1);
		p.p(dad2);
		
//		p.p(args[0]);
	}

}
