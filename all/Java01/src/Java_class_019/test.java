package Java_class_019;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.*;

import MyUtil.sql.sqlQuery;
import MyUtil.sql.sqlResults;
import MyUtil.Stopwatch;

public class test extends JFrame implements ActionListener {
	JLabel l1;
	JTextField tf1;
	JButton b1, b2;
	sqlQuery sq = null;
	sqlResults data = null;
	
	test(){
		sq =  new sqlQuery("localhost", "3307", "root", "root", "java");
		if (sq.cStatus()) {
			
		}
		
		l1 = new JLabel("쿼리문");
		l1.setBounds(20, 20, 100, 30);
		
		tf1 = new JTextField();
		tf1.setBounds(80, 20, 200, 140);
		
		b1 = new JButton("Query");
		b2 = new JButton("Update");
		b1.setBounds(20, 180, 80, 30);
		b2.setBounds(110, 180, 80, 30);
		b1.addActionListener(this);
		b2.addActionListener(this);

		add(l1);add(tf1);add(b1); add(b2);
		
		setSize(320, 320);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			try {
				Stopwatch.Flag();
				data = sq.query(tf1.getText());
				
				Stopwatch.Flag();
				String[] strs = data.split("&");
				for(String s:strs) {
					System.out.println(s.split("&")[1]);
				}
				Stopwatch.Flag();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			System.out.println("결과 값의 수: "+data.getCount());
			System.out.println("쿼리 소요시간: "+Stopwatch.getDuration(0, 1));
			System.out.println("출력 소요시간: "+Stopwatch.getDuration(1, 2));
			System.out.println("합계 소요시간: "+Stopwatch.getDuration(0, 2));
		}else if (e.getSource() == b2) {
			int rows = 0;
			try {
				Stopwatch.Flag();
				rows = sq.update(tf1.getText());
				Stopwatch.Flag();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			System.out.println(rows+"개의 컬럼에 영향이 감");
			System.out.println("쿼리 소요시간: "+Stopwatch.getDuration(0, 1));
		}
	}
	public static void main(String[] args) {
		new test();
	}
}
