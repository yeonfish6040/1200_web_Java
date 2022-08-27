package MyUtil.sql;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import MyUtil.Stopwatch;

public class sql_run extends JFrame implements ActionListener {
	JLabel l1, l2;
	JTextArea tf1, tf2;
	JButton b1, b2;
	sqlQuery sq = null;
	sqlResults data = null;
	JScrollPane sp1 = null;
	JScrollPane sp2 = null;

	sql_run(String[] loginInfo){
		// host port id pw db
		sq =  new sqlQuery(loginInfo[0], loginInfo[1], loginInfo[2], loginInfo[3], loginInfo[4]);
		
		l1 = new JLabel("쿼리문");
		l1.setBounds(20, 20, 100, 30);
		l2 = new JLabel("Waiting...");
		l2.setBounds(10, 800, 500, 200);
		
		tf1 = new JTextArea(10, 20);
		sp1 = new JScrollPane(tf1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp1.setBounds(80, 20, 700, 400);
		tf2 = new JTextArea(10, 20);
		sp2 = new JScrollPane(tf2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp2.setBounds(80, 430, 700, 400);
//		tf2.setEnabled(false);
		
		
		b1 = new JButton("Query");
		b2 = new JButton("Update");
		b1.setBounds(650, 900, 80, 30);
		b2.setBounds(500, 900, 80, 30);
		b1.addActionListener(this);
		b2.addActionListener(this);

		add(l1);add(l2);add(b1);add(b2);add(sp1);add(sp2);
		sp1.setVisible(true);
		sp2.setVisible(true);
		
		setSize(800, 1000);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			Stopwatch.clear();
			try {
				Stopwatch.Flag();
				data = sq.query(tf1.getText());
				Stopwatch.Flag();
				String[][] strs = data.get();
				String table = data.getTable();
				Stopwatch.Flag();
				tf2.setText(table);
				Stopwatch.Flag();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() { 
					sp2.getVerticalScrollBar().setValue(0);
				}
			});
			String resultStatus = "<html><pre>"+
					"결과 값의 수: "+data.getRowCount()+"<br>"+
					"쿼리 소요시간: "+Stopwatch.getDuration(0, 1)+"<br>"+
					"테이블링 소요시간: "+Stopwatch.getDuration(1, 2)+"<br>"+
					"출력 소요시간: "+Stopwatch.getDuration(2, 3)+"<br>"+
					"합계 소요시간: "+Stopwatch.getDuration(0, 3)+"</pre></html>";
			l2.setText(resultStatus);
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
		String[] loginInfo = {"localhost", "3307", "root", "root", "java"};
		new sql_run(loginInfo);
	}
}
