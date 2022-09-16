package Java_class_003;

public class ArrayTest {

	public static void main(String[] args) {
		System.out.println("**** Array Test ****");
		String[] student1 = new String[5];
		String[] student2 = {"A", "B", "C", "James", "E"};
		int[] student_score = new int[5];

//		for(int i=0;i<5;i++) {
//			System.out.println(student2[i]);
//		}
		
		System.out.println(student2.length);
		
//		for(int i=0;i<student2.length;i++) {
//			System.out.println(student2[i]);
//		}
		
//		for(String str : student2) {
//			System.out.println(str);
//		}
		
		// 2-d array
		int[][] m_array = new int[3][4];
		int[][] m_array2 = {{1,2,3}, {4,5,6}};
		int[][] m_array3 = {{1,2,3}, {4,5,6}};
		
		// 5를 선택하는방법
		System.out.println(m_array2[1][1]);
		System.out.println(m_array2[0]);
		System.out.println(m_array2);
		System.out.println(m_array3);
		System.out.println(m_array2 == m_array3);
	}

}
