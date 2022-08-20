package Java_class_018;

import java.util.Random;
import javax.swing.*;

import Java_class_017.MemberBean;
import Java_class_017.MemberDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MemberMain extends JFrame implements ActionListener {
	JLabel l1, l2, l3;
	JTextField tf1, tf2, tf3;
	JButton b1, b2, b3;
	sqlQuery sq;
	
	MemberMain(){
		sq = new sqlQuery("localhost", "3307", "root", "root", "java");
		if (sq.cStatus()) {
			
		}
		
		l1 = new JLabel("id");
		l2 = new JLabel("name");
		l3 = new JLabel("pw");
		l1.setBounds(20, 20, 100, 30);
		l2.setBounds(20, 60, 100, 30);
		l3.setBounds(20, 100, 100, 30);
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf1.setBounds(150, 20, 100, 30);
		tf2.setBounds(150, 60, 100, 30);
		tf3.setBounds(150, 100, 100, 30);
		
		b1 = new JButton("Insert");
		b2 = new JButton("Update");
		b3 = new JButton("Delete");
		b1.setBounds(20, 180, 80, 30);
		b2.setBounds(110, 180, 80, 30);
		b3.setBounds(200, 180, 80, 30);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		add(l1); add(l2); add(l3);
		add(tf1); add(tf2); add(tf3);
		add(b1); add(b2); add(b3);
		
		setSize(320, 320);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		String[][] value = {{"Id", "name", "pw"}, {tf1.getText(), tf2.getText(), tf3.getText()}};
		if(e.getSource() == b1) {					
			int rows = 0;
			try {
				rows = sq.insert("member", value);
			} catch (Exception err) {
				err.printStackTrace();
			}
			System.out.println(rows + " row(s) insert OK");
		}
		if(e.getSource() == b2) {					
			int rows = 0;
			try {
				rows = sq.update("member", value, 0);
			} catch (Exception err) {
				err.printStackTrace();
			}
			System.out.println(rows + " row(s) update OK");
		}
		if(e.getSource() == b3) {
			
			int ok = JOptionPane.showConfirmDialog(null, "Delete 옵션은 Id인자만 가지고 수행합니다.\n계속하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION);
			if(ok == 1) {
				JOptionPane.showMessageDialog(null, "취소되었습니다.", "작업 중단", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			int rows = 0;
			try {
				String[] dData = { value[0][0], value[1][0] };
				rows = sq.delete("member", dData);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			System.out.println(rows + " row(s) delete OK");
		}
	}
	
	public static void main(String[] args) {
		new MemberMain();
		
	}

}
