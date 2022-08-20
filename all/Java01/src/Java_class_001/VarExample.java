package Java_class_001;

public class VarExample {

	public static void main(String[] args) {
		// 1. char 자료형 테스트
		char ch = 49; // 49 = 0x39
		System.out.println("1. char test(49)");
		System.out.println("char ch = 49");
		System.out.println("output: " + ch);
		
		System.out.println();
		
		// 2. char 자료형을 int에 넣었을 때
		int ch_i = ch;
		System.out.println("2. data type casting test(char2int)");
		System.out.println("int ch_i = ch;");
		System.out.println("output: " + ch_i);
		
		System.out.println();
		
		// 3. char 자료형을 double에 넣을 때
		double ch_d = ch;
		System.out.println("3. data type casting test(char2double)");
		System.out.println("double ch_d = ch;");
		System.out.println("output: " + ch_d);
		
		System.out.println();
		
		// 4. 숫자로 문자 출력해보기
		ch = 121;
		System.out.println("4. teacher's homework");
		System.out.println("ch = 121;");
		System.out.println("output: " + ch);
		
		System.out.println();
		
		// 5. 두 글자 테스트
//		char ch2 = 'AB'; // Invalid character constant
		System.out.println("5. 2 length char test");
		System.out.println("char ch2 = \'AB\';");
		System.out.println("output: Invalid character constant");
		
		// 6. String 자료형
		String str = "Y.J.Lee";
		System.out.println("6. String type");
		System.out.println("String str = \"Y.J.Lee\";");
		System.out.println(str);
		
		System.out.println();
		
		// 7. String의 초기화
		String str2 = "aaaa";
		String str3 = "aaaa";
		String str4 = new String("aaaa");
		System.out.println("7. reset String");
		System.out.println("String str2 = \"aaaa\";");
		System.out.println("String str3 = \"aaaa\";");
		System.out.println("String str4 = new String(\"aaaa\");");
		System.out.println("output: " + str2 + ", " + str3 + ", " + str4);
		
		System.out.println();
		
		// 8. boolean 변수로 String값 비교
//		boolean b = 1; // cannot convert from int to boolean
		boolean b = true;
		b = (str2 == str3);
		boolean b2 = (str2 == str4);
		System.out.println("8. test String using boolean");
		System.out.println("boolean b = true;");
		System.out.println("b = (str2 == str3);");
		System.out.println("boolean b2 = (str2 == str4);");
		System.out.println("output: " + b + ", " + b2);
		
		System.out.println();
		
		// 9. 상수 테스트
		final double PI = 3.141592;
//		PI = 6; // The final local variable PI cannot be assigned. It must be blank and not using a compound assignment
		System.out.println("9. number test");
		System.out.println("final double PI = 3.141592;");
		System.out.println("PI = 6;");
		System.out.println("output: The final local variable PI cannot be assigned. It must be blank and not using a compound assignment");
		
		System.out.println();
		
		// 10. 형변환 테스트
		long num_l = 3;
//		int num_i = num_l; // cannot convert from long to int
		int num_i = (int)num_l;
		double num_d = 671.287352873;
		float num_f = (float)num_d;
		System.out.println("10. test type casting2");
		System.out.println("long num_l = 3;");
		System.out.println("int num_i = (int)num_l;");
		System.out.println("double num_d = 671.287352873;");
		System.out.println("float num_f = (float)num_d;");
		System.out.println("output: " + num_d + ", " + num_f);
		
		System.out.println();
		
		// 11. just test
		System.out.println("11. just test");
		System.out.println("10/3");
		System.out.println("10/3.");
		System.out.print("output: ");
		System.out.print(10/3);
		System.out.print(", ");
		System.out.print(10/3.);
		
		
	}

}
