package Java_class_006.Inher2;

public class SuperTest {

	public static void main(String[] args) {
		Child c = new Child();
		c.print();
		
		// 기본타입 캐스팅
		
		int i = 10;
		double d = i;
		
		double b = 10.3;
//		int j = b;
		
		boolean bl = true;
//		String str = (String)bl;
//		j = (int)bl
		
		// 클래스의 캐스팅
		Parent p1 = new Child();
		p1.eat();
		
//		Child c1 = new Parent(); Parent가 Child의 모든 기능 cover 불가
		Child c1 = (Child)p1;
		c1.eat();
		c1.cry();
	}

}
