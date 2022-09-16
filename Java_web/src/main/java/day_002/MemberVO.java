package day_002;

public class MemberVO {
	String name;
	String birthDay;
	public MemberVO() {
		this.name = "이름 없어";
		this.birthDay = "생일 없어";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	public String getBirthDay() {
		return birthDay;
	}
}
