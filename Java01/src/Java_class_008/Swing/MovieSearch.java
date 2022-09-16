package Java_class_008.Swing;

import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MovieSearch extends JFrame implements ActionListener {
	JLabel[] l = new JLabel[10];
	JLabel pageShow;
	JLabel score;
	JTextField tf1;
	JButton b1, b2, b3;
	
	int page = 1;
	
	public MovieSearch() {		
		tf1 = new JTextField();
		tf1.setBounds(20,30,200,30);
		
		b1 = new JButton("검색");
		b1.setBounds(230,30,60,30);
		
		score = new JLabel("N/A");
		score.setBounds(400,30,500,30);
		
		l[0] = new JLabel("");
		l[0].setBounds(20,80,1000,30);
		l[1] = new JLabel("");
		l[1].setBounds(20,100,1000,30);
		l[2] = new JLabel("");
		l[2].setBounds(20,120,1000,30);
		l[3] = new JLabel("");
		l[3].setBounds(20,140,1000,30);
		l[4] = new JLabel("");
		l[4].setBounds(20,160,1000,30);
		l[5] = new JLabel("");
		l[5].setBounds(20,180,1000,30);
		l[6] = new JLabel("");
		l[6].setBounds(20,200,1000,30);
		l[7] = new JLabel("");
		l[7].setBounds(20,220,1000,30);
		l[8] = new JLabel("");
		l[8].setBounds(20,240,1000,30);
		l[9] = new JLabel("");
		l[9].setBounds(20,260,1000,30);
		
		
		pageShow = new JLabel(String.valueOf(page));
		pageShow.setBounds(80,290,30,30);
		
		b2 = new JButton("<<");
		b2.setBounds(20,290,50,25);
		b3 = new JButton(">>");
		b3.setBounds(100,290,50,25);
		
		
		tf1.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		add(tf1);
		add(b1);
		add(b2);
		add(b3);
		add(pageShow);
		add(score);
		for(JLabel lTemp:l) {
			add(lTemp);
		}
		
		setTitle("Movie Search");
		setSize(800, 400);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MovieSearch();
	}
	
	public static void getAvgSc(String id, JLabel score) {
		String url = "https://movie.naver.com/movie/bi/mi/point.naver?code="+id;
		try {
			Document pointDoc = Jsoup.connect(url).get();
			Elements netizen_points = pointDoc.select("div#netizen_point_tab_inner>em");
			Elements actual_points = pointDoc.select("div#actual_point_tab_inner>em");
			System.out.println(netizen_points.text().replace(" ", ""));
			System.out.println(actual_points);
			String showText = "네티즌 평점: "+netizen_points.text().replace(" ", "");
			score.setText(showText);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void getComment(JTextField tf1, JLabel[] l, int page, JLabel score) {
		String textTemp = tf1.getText();
		String urlTemp = "https://movie.naver.com/movie/search/result.naver?query="+textTemp;
		try {
			Document docTemp = Jsoup.connect(urlTemp).get();
			Element elTemp = docTemp.select("p.result_thumb a").first();
			if(elTemp == null) {
				tf1.setText("검색결과가 없습니다");
				return;
			}
			String movieName = docTemp.select("ul.search_list_1 li dl dt a").first().text();
			tf1.setText(movieName);
			String id = elTemp.attr("href").replace("/movie/bi/mi/basic.naver?code=", "");
			String url = "https://movie.naver.com/movie/bi/mi/pointWriteFormList.naver?code="+id+"&page="+String.valueOf(page);
			getAvgSc(id, score);
			Document doc = Jsoup.connect(url).get();
			Elements els = doc.select("div.score_result ul li div.score_reple p span:not(.ico_viewer)");
			els = els.select("span:not(._unfold_ment)");
			System.out.println(url);
			System.out.println(els);
			if(Jsoup.connect(url).get().select("div.no_score_info").text().equals("국내 개봉 전이라 평점을 등록할 수 없습니다.")) {
				for(JLabel l2:l) {
					l2.setText("평이 없습니다");
				}
			}
			int i = 0;
			for(Element el:els) {
				String texts = el.text();
				l[i].setText(String.valueOf(i+1)+". "+texts);
				i++;		
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(b1.equals(e.getSource()) || tf1.equals(e.getSource())) {
			page = 1;
			pageShow.setText(String.valueOf(page));
			getComment(tf1, l, page, score);
		}
		if(b2.equals(e.getSource())) {
			if(page != 1) {
				page--;
				pageShow.setText(String.valueOf(page));
			}else {
				return;
			}
			getComment(tf1, l, page, score);
		}
		if(b3.equals(e.getSource())) {
			page++;
			pageShow.setText(String.valueOf(page));
			getComment(tf1, l, page, score);
		}
	}
}
