package Java_class_7.Inter2;

public class CalcMain {
	public static void main(String[] args) {
		Calculate c = new Calculate();
		c.setOperand(10, 21, 30);
		System.out.println(c.sum());
		System.out.println(c.avg());
	}
	
	class CalculatorDummy implements CalcInterface {
		public void setOperand(int first, int second, int third) {}
		
		public int sum() { return 10; }
		public double avg() { return 0.0d; }
	}
	
}
