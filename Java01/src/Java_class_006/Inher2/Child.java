package Java_class_006.Inher2;

public class Child extends Parent {
	int number = 2;
	
	Child(){
		System.out.println("Create Child Object");
	}
	
	void print() {
		int number = 1;
		System.out.println("number: "+number);
		System.out.println("this.number: "+this.number);
		System.out.println("super.number: "+super.number);
	}
	
	void eat() {
		System.out.println("돼지고기 10인분을 먹었습니다.");
	}
	
	void cry() {
		System.out.println("레고를 사달라고 웁니다.");
	}
}
