package Java_class_8.Swing;

import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.tree.*;


public class GUI_Test {

	public static void main(String[] args) {
		// JFrame
		JFrame f = new JFrame("Java Swing Test");
		
		JLabel l1 = new JLabel("this is a text"); f.add(l1);
		
		JTextField t1 = new JTextField("this is a text"); f.add(t1);
		
		JButton b1 = new JButton("Ok"); f.add(b1);
		
		String[] gui = {"Swing","awt"};
		JList list = new JList(gui); f.add(list);
		
		String data[][] = {
				{
					"Python",
					"Good"
				},{
					"C++",
					"VeryBad"
				},{
					"Java",
					"Diff"
				}
		};
		
		String colname[] = {"Subject", "Feel"};
		
		JTable table = new JTable(data, colname);	f.add(table);
		
		JSpinner spinner = new JSpinner(); f.add(spinner);
		
		
		
		
		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu("File"); menubar.add(fileMenu);		
		JMenu item1 = new JMenu("Open");	fileMenu.add(item1);
		JMenu item2 = new JMenu("Save");	fileMenu.add(item2);
		
		JMenu helpMenu = new JMenu("help"); menubar.add(helpMenu);
		
		f.add(menubar);
		
		f.setSize(800, 450);
		f.setLayout(new GridLayout(3,3));
		f.setVisible(true);
	}

}
