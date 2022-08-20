package Java_class_005;

public class Person {
//	Field(Member Variable)
	private String name;
	private int age;
	
	// Constructor
	Person(){
		
	}
	
	Person(int i){
		age = i;
	}
	
	Person(String str){
		name = str;
	}
	
//	Method (Member function)
	public void hit() {
		System.out.println(name+"이 말했습니다. \"왜 때려요\"");
		
	}
}
