package Java_class_5;

public class ClassTest {

	public static void main(String[] args) {
		Person p = new Person();
		p.hit();
		
		
		// static 함수의 경우는 이런 식의 호출도 가능
		Person p1 = new Person(50);
		p1.hit();
		Person p2 = new Person("Son");
		p2.hit();
//		System.out.println(p.name);
	}
}
