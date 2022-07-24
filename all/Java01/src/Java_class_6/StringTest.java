package Java_class_6;

import java.util.Scanner;

public class StringTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str1 = "abcde";
		String str2 = "abcde";
		System.out.println(str1 == str2);
		
		
		str1 = "abcdeasfdf";
		str2 = "abcdef";
		str2 = "ddddd";
		str2 = "abcde";
		str1 = "abcde";
		
		System.out.println(str1 == str2);
		
		String str3 = new String("abcde");
		String str4 = new String("abcde");
		System.out.println(str3 == str4);
		
		String s1 = "ashdfahsbdjfbgabfhalskjdhglkajhsldfgvnajsdlnkdrjf";
		String s2 = "한글은 몇글자로 침?";
		System.out.println("s1 문자열의 길이: "+s1.length());
		System.out.println("s2 문자열의 길이: "+s2.length());
		
		String s3 = "asdfasdfasd1238uy9812n39c8c1y983yn89r1981083y0r1c98y4nvn2378f";
		System.out.println(s3.charAt(9));
		
		String s4 = new String("aaaaaaaaaaa");
		String s5 = new String("aaaaaaaaaaa");
		String s6 = new String("AAAaaAaaAaa");
		System.out.println(s4==s5);
		System.out.println(s4.equals(s5));
		System.out.println(s4.equals(s6));
		System.out.println(s4.equalsIgnoreCase(s6));
		
		String s7 = "Heaven helps those";
		String s8 = "help";
		String s9 = s7.replace(s8, "   ");
		String s10 = s7.replace("t", "94712837409384");
		System.out.println(s9);
		System.out.println(s10);
		
		String s11 = s7.substring(1, 4);
		System.out.println(s11);
		
		String s12 = "          asdhfka         ";
		System.out.println(s12.trim());
		
		String s13 = "Victory comes from right";
		String[] s14 = s13.split(" ");
		for(String i:s14) {
			System.out.println(i);
		}
		
		String[] s15 = s13.split("[ ]");
		for(String i:s15) {
			System.out.println(i);
		}
		
		String s16 = "010-7123-1245";
		// 숫자와 -로만 25자리 이내로 구성되었는가?
		System.out.println(s16.matches("[0-9-]{1,13}"));
		
		// 영 대소문자 또는 한글로 5자 이내인가?
		String nameRule = "[a-zA-Z가-힣]{1,5}";
		System.out.println("이연준".matches(nameRule));
		
		String phoneRule = "[0][0-9]{1,2}[-]{0,1}[0-9]{3,4}[-]{0,1}[0-9]{4}";
		String phone = "010-6782-0989";
		System.out.println(phone.matches(phoneRule));
		
		// Test
		// 사용자로부터 전화번호 입력을 받아서 전화번호 규칙에 맞으면 마지막 4자리를 ****로 표시
		// 규칙에 어긋나면 "올바른 형식이 아닙니다"
		while(true) {
			System.out.print("전화번호를 입력하여 주세요: ");
			String user_input = sc.next();
			String regex = "[0][0-9]{1,2}[-]{0,1}[0-9]{3,4}[-]{0,1}[0-9]{4}";
			if(user_input.matches(regex)) {
//				System.out.println(user_input.replace(user_input.substring(user_input.length()-4, user_input.length()), "****")); # 중간 4자리와 뒤 4자리가 같을경우 오작동
//				String protect = user_input.split("-")[0]+"-"+user_input.split("-")[1]+"-"+"****";
//				System.out.println(protect);
				System.out.println(user_input.substring(0, user_input.length()-4)+"****");
				break;
			}
			System.out.println("다시 입력하여주세요");
		}
		
		
		
		
	}
}
