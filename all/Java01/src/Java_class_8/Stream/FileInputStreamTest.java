package Java_class_8.Stream;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.SequenceInputStream;
import java.net.URL;


public class FileInputStreamTest {
	public static void main(String[] argv) {
		
		String dir = "src/Java_class_8/Stream/";
		
		System.out.println("File Input Stream");
		try {
			FileInputStream fis = new FileInputStream(dir+"input1.txt");
			int i = fis.read();
//			System.out.println((char)i);
			while(i!=-1) {
				System.out.print((char)i);
				i = fis.read();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("File Reader Stream");
		FileReader b = null;
		try {
			b = new FileReader(dir+"input2.txt");
			int i = b.read();
			while(i != -1) {
				System.out.print((char)i);
				i = b.read();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("Scanner");
		
		File f = new File(dir+"input3.txt");
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNext()) {
				System.out.println(sc.next());
			}
			sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
//		System.out.println("Image");
//		String filename = dir+"image.png";
//		try {
//			InputStream is = new FileInputStream(filename);
//			byte[] buffer = new byte[is.available()];
//			System.out.println(is.available());
//			
//			is.read(buffer);
//			
//			int i = 0;
//			
//			for(byte b1:buffer) {
//				if(i%10==0) {
//					System.out.println();
//				}
//				System.out.printf("%02x ", b1);
//				i++;
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		System.out.println("url");
//		String web = "https://bugs.co.kr";
//		try {
//			URL url = new URL(web);
//			InputStream is = url.openStream();
//			BufferedReader br = new BufferedReader(new InputStreamReader(is));
//			
//			br.lines().forEach(System.out::println);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		System.out.println("SequenceInputStream");
		String filename1 = dir+"input1.txt";
		String filename2 = dir+"input1.txt";
		String filename3 = dir+"input1.txt";
		try {
			InputStream is1 = new FileInputStream(filename1);
			InputStream is2 = new FileInputStream(filename2);
			InputStream is3 = new FileInputStream(filename3);
			SequenceInputStream sis1 = new SequenceInputStream(is1, is2);
			SequenceInputStream sis2 = new SequenceInputStream(sis1, is3);
			
			int b2 = sis2.read();
			
			while (b2!=-1) {
				System.out.print((char)b2);
				b2 = sis2.read();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
