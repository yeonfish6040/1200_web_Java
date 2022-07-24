package Java_class_5;

public class ConstructorExample {
	public static void main(String[] args) {
		
		Car c1 = new Car();
		System.out.println(c1.color+":"+c1.name+":"+c1.type);
		
		Car c2 = new Car("검정색", "포르쉐", "풀옵션");
		System.out.println(c2.color+":"+c2.name+":"+c2.type);
	}
}

class Car {
	String color;
	String name;
	String type;
	Car(){
		this("미정", "개발중인차", "기본형");
		System.out.println("Car()");
	}
	
	Car(String color, String name, String type){
		this.color = color;
		this.name = name;
		this.type = type;
		System.out.println("Car(....)");
	}
	
	static {
		System.out.println("static {}");
	}
	{
		System.out.println("{}");
	}
	
}
