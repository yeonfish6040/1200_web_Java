package Java_class_005;

public class AuthExample {

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.a);
//		System.out.println(t.b);
		System.out.println(t.getB());
	}

}

class Test {
	public int a = 3;
	private int b = 5;
	
	public int getB() {
		return b;
	}
}