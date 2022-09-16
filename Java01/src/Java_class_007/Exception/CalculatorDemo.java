package Java_class_007.Exception;

public class CalculatorDemo {
	public static void main(String[] argv) {
		Calculator c = new Calculator();
		c.setOperand(14, 5);
		c.divide();
		c.setOperand(100, 0);
		c.divide();
	}
}

class Calculator {
	int left, right;
	public void setOperand(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	// 예외처리를 하지 않음
//	public void divide() {
//		System.out.println(left/right);
//	}
	public void divide() {
		try {
			System.out.println(left/right);
		} catch(ArithmeticException e) {
			System.out.println("너 0으로 나눴냐?");
			System.out.println("오늘만 용서해준다.");
			e.printStackTrace();
			System.out.println(left/1);
		} catch(Exception e) {
			System.out.println("이건 무조건 걸린다.");
		} finally {
			System.out.println("이용해주셔서 감사합니다");
		}
		
	}
}