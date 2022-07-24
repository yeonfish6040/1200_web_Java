package Java_class_3;

import MyUtil.Colors;
import MyUtil.Shapes;

public class ColorTest {

	public static void main(String[] args) {
		System.out.println(Shapes.S_LAY + Shapes.S_BOLD + Shapes.S_RVLINE + Colors.RED + "Color Test" + Colors.END);
		
//		// extended 256 color
//		for(int color=0;color<256;color++) {
//			System.out.print("\033[48;5;"+color+"m"+" ");
//		}
//		System.out.println(Colors.END);
		
//		String[] str = {"", "", "", ""};
//		for(int color=128;color<256;color++) {
//			str[0] += "\033[48;2;"+color+";0;0m"+" ";
//			str[1] += "\033[48;2;0;"+color+";0m"+" ";
//			str[2] += "\033[48;2;0;0;"+color+"m"+" ";
//			str[3] += "\033[48;2;"+color+";"+color+";"+color+"m"+" ";
//		}
//		for(String st : str) {
//			System.out.println(st);
//		}
		Colors.p("hi", 4);
	}

}
